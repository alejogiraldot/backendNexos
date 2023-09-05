package com.inventario.nexos.infrastructure.adapter;

import com.inventario.nexos.domain.application.ports.output.repository.UserNexosRepository;
import com.inventario.nexos.domain.core.entity.UserNexos;
import com.inventario.nexos.infrastructure.entity.MerchandiseEntity;
import com.inventario.nexos.infrastructure.entity.UserNexosEntity;
import com.inventario.nexos.infrastructure.mapper.UserNexosInfrastructureMapper;
import com.inventario.nexos.infrastructure.repository.UserNexosJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class UserNexosRepositoryImpl implements UserNexosRepository {
    private final UserNexosJpaRepository userNexosJpaRepository;
    private final UserNexosInfrastructureMapper userNexosInfrastructureMapper;

    public UserNexosRepositoryImpl(UserNexosJpaRepository userNexosJpaRepository, UserNexosInfrastructureMapper userNexosInfrastructureMapper) {
        this.userNexosJpaRepository = userNexosJpaRepository;
        this.userNexosInfrastructureMapper = userNexosInfrastructureMapper;
    }

    @Override
    public UserNexos save(UserNexos user) {
        return userNexosInfrastructureMapper.userEntityToUserNexos(userNexosJpaRepository.save(userNexosInfrastructureMapper.userNexosToUserEntity(user)));
    }

    @Override
    public Optional<UserNexos> findById(Integer id) {
        return userNexosJpaRepository.findById(id).map(userNexosInfrastructureMapper::userEntityToUserNexos);
    }

    @Override
    public UserNexos findByUserName(String userName) {
        return userNexosInfrastructureMapper.userEntityToUserNexos(userNexosJpaRepository.findByUserName(userName));
    }

    @Override
    public List<UserNexos> findAll() {
        List<UserNexosEntity> userNexosEntities = userNexosJpaRepository.findAll();
        return userNexosInfrastructureMapper.merchandisesEntityToMerchandise(userNexosEntities);
    }
}

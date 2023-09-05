package com.inventario.nexos.infrastructure.adapter;

import com.inventario.nexos.domain.application.ports.output.repository.MerchandiseRepository;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.infrastructure.entity.MerchandiseEntity;
import com.inventario.nexos.infrastructure.mapper.MerchandiseInfrastructureMapper;
import com.inventario.nexos.infrastructure.repository.MerchandiseJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public class MerchandiseRepositoryImpl implements MerchandiseRepository {

    private final MerchandiseJpaRepository merchandiseJpaRepository;
    private final MerchandiseInfrastructureMapper merchandiseInfrastructureMapper;

    public MerchandiseRepositoryImpl(MerchandiseJpaRepository merchandiseJpaRepository, MerchandiseInfrastructureMapper merchandiseInfrastructureMapper) {
        this.merchandiseJpaRepository = merchandiseJpaRepository;
        this.merchandiseInfrastructureMapper = merchandiseInfrastructureMapper;
    }

    @Override
    public Merchandise save(Merchandise merchandise) {
        return merchandiseInfrastructureMapper.merchandiseEntityToMerchandise(merchandiseJpaRepository.save(merchandiseInfrastructureMapper.merchandiseToMerchandiseEntity(merchandise)));
    }

    @Override
    public Merchandise findByProductName(String productName) {
        return merchandiseInfrastructureMapper.merchandiseEntityToMerchandise(merchandiseJpaRepository.findByProductName(productName));
    }

    @Override
    public void deleteById(Integer id) {
        merchandiseJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Merchandise> findById(Integer id) {
        return merchandiseJpaRepository.findById(id).map(merchandiseInfrastructureMapper::merchandiseEntityToMerchandise);
    }

    @Override
    public Merchandise update(Merchandise merchandise) {
        MerchandiseEntity merchandiseEntity = merchandiseInfrastructureMapper.merchandiseToMerchandiseEntity(merchandise);
        MerchandiseEntity save = merchandiseJpaRepository.save(merchandiseEntity);
        return merchandiseInfrastructureMapper.merchandiseEntityToMerchandise(save);
    }

    @Override
    public List<Merchandise> findByAdmissionDate(String admissionDate) {
        List<MerchandiseEntity> merchandiseEntities = merchandiseJpaRepository.findByAdmissionDate(LocalDate.parse(admissionDate));
        return merchandiseInfrastructureMapper.merchandisesEntityToMerchandise(merchandiseEntities);
    }


}


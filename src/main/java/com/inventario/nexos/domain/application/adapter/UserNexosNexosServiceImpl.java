package com.inventario.nexos.domain.application.adapter;

import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexos;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexosResponse;
import com.inventario.nexos.domain.application.dto.usernexos.FindNewUserNexosReponse;
import com.inventario.nexos.domain.application.mapper.UserNexosApplicationMapper;
import com.inventario.nexos.domain.application.ports.input.service.UserNexosService;
import com.inventario.nexos.domain.application.ports.output.repository.UserNexosRepository;
import com.inventario.nexos.domain.core.entity.UserNexos;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserNexosNexosServiceImpl implements UserNexosService {

    private final UserNexosRepository userNexosRepository;
    private final UserNexosApplicationMapper userNexosApplicationMapper;

    public UserNexosNexosServiceImpl(UserNexosRepository userNexosRepository, UserNexosApplicationMapper userNexosApplicationMapper) {
        this.userNexosRepository = userNexosRepository;
        this.userNexosApplicationMapper = userNexosApplicationMapper;
    }

    @Override
    public CreateNewUserNexosResponse createUserNexos(CreateNewUserNexos createNewUserNexos) {
        UserNexos user = userNexosApplicationMapper.createNewUserNexosToUserNexos(createNewUserNexos);
        user.setAddmisionUserDate(LocalDate.now());
        return userNexosApplicationMapper.UserNexosToCreateNewUserNexosResponse(userNexosRepository.save(user));
    }

    @Override
    public FindNewUserNexosReponse findUserNexosById(Integer id) {
        return userNexosApplicationMapper.userNexosToFindNewUserNexosResponse(userNexosRepository.findById(id).orElseThrow());
    }

    @Override
    public FindNewUserNexosReponse findUserNexosByName(String userName) {
        return userNexosApplicationMapper.userNexosToFindNewUserNexosResponse(userNexosRepository.findByUserName((userName)));
    }

    @Override
    public List<FindNewUserNexosReponse> findAllUserNexos() {
        List<UserNexos> userNexos = userNexosRepository.findAll();
        return userNexosApplicationMapper.merchadinseListToFindMerchadinseResponsesList(userNexos);
    }


}

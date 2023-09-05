package com.inventario.nexos.domain.application.ports.input.service;

import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexos;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexosResponse;
import com.inventario.nexos.domain.application.dto.usernexos.FindNewUserNexosReponse;
import com.inventario.nexos.domain.core.entity.UserNexos;

import java.util.List;


public interface UserNexosService {
    CreateNewUserNexosResponse createUserNexos(CreateNewUserNexos createNewUserNexos);
    FindNewUserNexosReponse findUserNexosById(Integer id);
    FindNewUserNexosReponse findUserNexosByName(String userName);
    List<FindNewUserNexosReponse> findAllUserNexos();

}

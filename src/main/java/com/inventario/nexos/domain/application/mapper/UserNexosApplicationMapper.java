package com.inventario.nexos.domain.application.mapper;


import com.inventario.nexos.domain.application.dto.merchandise.FindMerchandiseReponse;
import com.inventario.nexos.domain.application.dto.merchandise.UpdateMerchandiseResponse;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexos;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexosResponse;

import com.inventario.nexos.domain.application.dto.usernexos.FindNewUserNexosReponse;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.entity.UserNexos;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserNexosApplicationMapper {
    public UserNexos createNewUserNexosToUserNexos (CreateNewUserNexos createNewUserNexos) {
        return UserNexos.builder()
                .age(createNewUserNexos.getAge())
                .userName(createNewUserNexos.getUserName())
                .userType(createNewUserNexos.getUserType())
                .build();
    }

    public CreateNewUserNexosResponse UserNexosToCreateNewUserNexosResponse (UserNexos user) {
        return CreateNewUserNexosResponse.builder()
                .age(user.getAge())
                .userName(user.getUserName())
                .addmisionUserDate(user.getAddmisionUserDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .userType(user.getUserType())
                .build();
    }

    public FindNewUserNexosReponse userNexosToFindNewUserNexosResponse(UserNexos userNexos){
        return FindNewUserNexosReponse.builder()
                .addmisionUserDate(userNexos.getAddmisionUserDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .userName(userNexos.getUserName())
                .age(userNexos.getAge())
                .userType(userNexos.getUserType())
                .build();
    }

    public FindNewUserNexosReponse userNexosToFinduserNexosResponses(UserNexos userNexos) {
        return new FindNewUserNexosReponse(
                userNexos.getId(),
                userNexos.getUserName(),
                userNexos.getAge(),
                userNexos.getAddmisionUserDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                userNexos.getUserType()
        );
    }

    public List<FindNewUserNexosReponse> merchadinseListToFindMerchadinseResponsesList(List<UserNexos> userNexos) {
        return userNexos.stream()
                .map(this::userNexosToFinduserNexosResponses)
                .collect(Collectors.toList());
    }

}

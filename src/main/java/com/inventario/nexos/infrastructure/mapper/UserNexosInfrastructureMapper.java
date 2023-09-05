package com.inventario.nexos.infrastructure.mapper;

import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.entity.UserNexos;
import com.inventario.nexos.infrastructure.entity.MerchandiseEntity;
import com.inventario.nexos.infrastructure.entity.UserNexosEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserNexosInfrastructureMapper {

    public UserNexosEntity userNexosToUserEntity(UserNexos user){
        return UserNexosEntity.builder()
                .userType(user.getUserType())
                .age(user.getAge())
                .userName(user.getUserName())
                .addmisionUserDate(user.getAddmisionUserDate())
                .build();
    }

    public UserNexos userEntityToUserNexos(UserNexosEntity userNexosEntity){
        return UserNexos.builder()
                .userType(userNexosEntity.getUserType())
                .id(userNexosEntity.getId())
                .userName(userNexosEntity.getUserName())
                .addmisionUserDate(userNexosEntity.getAddmisionUserDate())
                .age(userNexosEntity.getAge())
                .build();
    }

    public UserNexos userNexosEntityToUserNexos(UserNexosEntity userNexosEntity){
        return UserNexos.builder()
                .id(userNexosEntity.getId())
                .userName(userNexosEntity.getUserName())
                .addmisionUserDate(userNexosEntity.getAddmisionUserDate())
                .age(userNexosEntity.getAge())
                .userType(userNexosEntity.getUserType())
                .build();
    }

    public List<UserNexos> merchandisesEntityToMerchandise(List<UserNexosEntity> userNexosEntities) {
        return userNexosEntities.stream()
                .map(this::userNexosEntityToUserNexos)
                .collect(Collectors.toList());
    }
}

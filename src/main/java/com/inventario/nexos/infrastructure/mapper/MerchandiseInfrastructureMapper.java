package com.inventario.nexos.infrastructure.mapper;

import com.inventario.nexos.domain.application.dto.merchandise.FindMerchandiseReponse;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.entity.UserNexos;
import com.inventario.nexos.infrastructure.entity.MerchandiseEntity;
import com.inventario.nexos.infrastructure.entity.UserNexosEntity;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MerchandiseInfrastructureMapper {
    public MerchandiseEntity merchandiseToMerchandiseEntity(Merchandise merchandise){
        return MerchandiseEntity.builder()
                .id(merchandise.getId())
                .productName(merchandise.getProductName())
                .quantity(merchandise.getQuantity())
                .admissionDate(merchandise.getAdmissionDate())
                .userWhoRegisters(UserNexosEntity.builder()
                        .id(merchandise.getUserWhoRegisters().getId())
                        .build())
                .build();
    }

    public Merchandise merchandiseEntityToMerchandise(MerchandiseEntity merchandiseEntity){
        return Merchandise.builder()
                .id(merchandiseEntity.getId())
                .productName(merchandiseEntity.getProductName())
                .quantity(merchandiseEntity.getQuantity())
                .admissionDate(merchandiseEntity.getAdmissionDate())
                .userWhoRegisters(userNexosEntityToUserNexos(merchandiseEntity.getUserWhoRegisters()))

                .build();
    }

    public UserNexos userNexosEntityToUserNexos(UserNexosEntity userNexosEntity){
        return UserNexos.builder()
                .id(userNexosEntity.getId())
                .addmisionUserDate(userNexosEntity.getAddmisionUserDate())
                .age(userNexosEntity.getAge())
                .userName(userNexosEntity.getUserName())
                .build();

    }

    public List<Merchandise> merchandisesEntityToMerchandise(List<MerchandiseEntity> merchandiseEntities) {
        return merchandiseEntities.stream()
                .map(this::merchandiseEntityToMerchandise)
                .collect(Collectors.toList());
    }

}

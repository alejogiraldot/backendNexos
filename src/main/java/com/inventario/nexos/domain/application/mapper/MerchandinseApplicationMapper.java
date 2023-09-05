package com.inventario.nexos.domain.application.mapper;

import com.inventario.nexos.domain.application.dto.merchandise.*;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.entity.UserNexos;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MerchandinseApplicationMapper {

    public Merchandise createNewMerchandiseToMerchandise (CreateNewMerchandise createNewMerchandise){
        return Merchandise.builder()
                .id(createNewMerchandise.getId())
                .userWhoRegisters(createNewMerchandise.getUserWhoRegisters())
                .productName(createNewMerchandise.getProductName())
                .quantity(createNewMerchandise.getQuantity())
                .build();
    }

    public CreateMerchandiseResponse merchandiseToCreateMerchandiseResponse(Merchandise merchandise){
        return CreateMerchandiseResponse.builder()
                .productName(merchandise.getProductName())
                .admissionDate(merchandise.getAdmissionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .quantity(merchandise.getQuantity())
                .userWhoRegisters(merchandise.getUserWhoRegisters())
                .build();
    }

    public FindMerchandiseReponse merchandiseToFindMerchandiseResponse(Merchandise merchandise){
        return FindMerchandiseReponse.builder()
                .id(merchandise.getId())
                .productName(merchandise.getProductName())
                .admissionDate(merchandise.getAdmissionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .quantity(merchandise.getQuantity())
                .userWhoRegisters(merchandise.getUserWhoRegisters().getUserName())
                .build();
    }

    public DeleteMerchandise merchandiseDelete(Merchandise merchandise){
        return DeleteMerchandise.builder()
                .id(merchandise.getId())
                .userWhoRegisters(merchandise.getUserWhoRegisters())
                .build();
    }

    public UpdateMerchandiseResponse merchandiseToUpdateMerchandise(Merchandise merchandise){
        return UpdateMerchandiseResponse.builder()
                .admissionDate(merchandise.getAdmissionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .productName(merchandise.getProductName())
                .quantity(merchandise.getQuantity())
                .build();
    }
    public FindMerchandiseReponse merchandiseToFindMerchandiseResponses(Merchandise merchandise) {
        return new FindMerchandiseReponse(
                merchandise.getId(),
                merchandise.getProductName(),
                merchandise.getAdmissionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                merchandise.getId(),
                merchandise.getUserWhoRegisters().getUserName()
        );
    }

    public List<FindMerchandiseReponse> merchadinseListToFindMerchadinseResponsesList(List<Merchandise> merchandises) {
        return merchandises.stream()
                .map(this::merchandiseToFindMerchandiseResponses)
                .collect(Collectors.toList());
    }
}

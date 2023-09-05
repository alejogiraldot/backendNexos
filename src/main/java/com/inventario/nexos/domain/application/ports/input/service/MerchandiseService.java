package com.inventario.nexos.domain.application.ports.input.service;

import com.inventario.nexos.domain.application.dto.merchandise.*;

import java.time.LocalDate;
import java.util.List;

public interface MerchandiseService {

    CreateMerchandiseResponse createMerchandise(CreateNewMerchandise createNewMerchandise);
    FindMerchandiseReponse findByProductName(String productName);
    void deleteById(DeleteMerchandise deleteMerchandise);
    FindMerchandiseReponse findById(Integer id);
    UpdateMerchandiseResponse update(UpdateMerchandiseRequest updateMerchandiseRequest , Integer id);
    List<FindMerchandiseReponse> findByAdmissionDate(String admissionDate);


}

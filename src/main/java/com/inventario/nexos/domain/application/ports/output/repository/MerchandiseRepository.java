package com.inventario.nexos.domain.application.ports.output.repository;

import com.inventario.nexos.api.MerchandiseController;
import com.inventario.nexos.domain.application.dto.merchandise.DeleteMerchandise;
import com.inventario.nexos.domain.core.entity.Merchandise;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MerchandiseRepository {
    Merchandise save(Merchandise merchandise);
    Merchandise findByProductName(String productName);
    void deleteById(Integer id);
    Optional<Merchandise> findById(Integer id);
    Merchandise update(Merchandise merchandise);
    List<Merchandise> findByAdmissionDate(String admissionDate);


}

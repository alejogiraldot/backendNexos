package com.inventario.nexos.infrastructure.repository;

import com.inventario.nexos.infrastructure.entity.MerchandiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MerchandiseJpaRepository extends JpaRepository<MerchandiseEntity,Integer> {
    MerchandiseEntity findByProductName(String productName);
    List<MerchandiseEntity> findByAdmissionDate(LocalDate admissionDate);
}

package com.inventario.nexos.domain.application.dto.merchandise;

import com.inventario.nexos.domain.core.entity.UserNexos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class FindMerchandiseReponse {
    private final Integer id;
    private final String productName;
    private final String admissionDate;
    private final Integer quantity;
    private final String userWhoRegisters;
}

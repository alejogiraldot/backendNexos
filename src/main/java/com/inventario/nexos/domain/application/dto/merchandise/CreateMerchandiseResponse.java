package com.inventario.nexos.domain.application.dto.merchandise;

import com.inventario.nexos.domain.core.entity.UserNexos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateMerchandiseResponse {

    private final String productName;
    private final String admissionDate;
    private final Integer quantity;
    private final UserNexos userWhoRegisters;
}

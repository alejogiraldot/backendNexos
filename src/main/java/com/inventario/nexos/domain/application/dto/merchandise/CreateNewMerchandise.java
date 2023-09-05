package com.inventario.nexos.domain.application.dto.merchandise;

import com.inventario.nexos.domain.core.entity.UserNexos;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class CreateNewMerchandise {
    private  final Integer id;
    @NotNull
    private final UserNexos userWhoRegisters;

    @NotNull
    private final String productName;

    @NotNull
    private final Integer quantity;

}

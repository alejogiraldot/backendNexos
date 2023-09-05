package com.inventario.nexos.domain.application.dto.usernexos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateNewUserNexos {
    @NotNull
    private final String userName;
    @NotNull
    private final String age;
    @NotNull
    private final String userType;
}

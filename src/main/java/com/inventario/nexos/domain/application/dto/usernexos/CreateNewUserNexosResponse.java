package com.inventario.nexos.domain.application.dto.usernexos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateNewUserNexosResponse {
    private final String userName;

    private final String age;

    private final String addmisionUserDate;
    private final String userType;
}

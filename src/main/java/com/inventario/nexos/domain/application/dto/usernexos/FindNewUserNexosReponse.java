package com.inventario.nexos.domain.application.dto.usernexos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FindNewUserNexosReponse {
    private final Integer id;
    private final String userName;
    private final String  age;
    private final String addmisionUserDate;
    private final String userType;
}

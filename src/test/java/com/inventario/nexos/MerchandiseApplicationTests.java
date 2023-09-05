package com.inventario.nexos;

import com.inventario.nexos.domain.application.adapter.MerchandiseServiceImpl;
import com.inventario.nexos.domain.application.adapter.UserNexosNexosServiceImpl;
import com.inventario.nexos.domain.application.dto.merchandise.CreateMerchandiseResponse;
import com.inventario.nexos.domain.application.dto.merchandise.CreateNewMerchandise;
import com.inventario.nexos.domain.application.dto.merchandise.FindMerchandiseReponse;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexos;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexosResponse;
import com.inventario.nexos.domain.application.dto.usernexos.FindNewUserNexosReponse;
import com.inventario.nexos.domain.application.mapper.MerchandinseApplicationMapper;
import com.inventario.nexos.domain.application.mapper.UserNexosApplicationMapper;
import com.inventario.nexos.domain.application.ports.input.service.MerchandiseService;
import com.inventario.nexos.domain.application.ports.input.service.UserNexosService;
import com.inventario.nexos.domain.application.ports.output.repository.MerchandiseRepository;
import com.inventario.nexos.domain.application.ports.output.repository.UserNexosRepository;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.entity.UserNexos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MerchandiseApplicationTests {

    @Mock
    private MerchandiseRepository merchandiseRepository;
    @Autowired
    private MerchandinseApplicationMapper merchandinseApplicationMapper;
    private MerchandiseService merchandiseService;

    private Merchandise merchandise;
    private CreateNewMerchandise createNewMerchandise;
    private CreateMerchandiseResponse createMerchandiseResponse;
    private UserNexosRepository userNexosRepository;

    private FindMerchandiseReponse findMerchandiseReponse;
    private final Integer ID = 1;
    private final int quantity = 17;
    private final String age="17";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        merchandinseApplicationMapper = new MerchandinseApplicationMapper();
        merchandiseService = new MerchandiseServiceImpl(merchandinseApplicationMapper,merchandiseRepository,userNexosRepository);

    }

    @Test
    void findNewMerchandise_givenMechandiseName_thenShouldReturnFindNewMerchandiseResponse() {
        merchandise = Merchandise.builder()
                .productName("Ferrari")
                .admissionDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .quantity(quantity)
                .userWhoRegisters(UserNexos.builder()
                        .id(ID)
                        .age(age)
                        .userType("administrador")
                        .userName("Miguel")
                        .addmisionUserDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        .build()
                )
                .build();
        findMerchandiseReponse = FindMerchandiseReponse.builder()
                .productName("Ferrari")
                .admissionDate("04/09/2023")
                .quantity(quantity)
                .userWhoRegisters("Miguel")
                .build();
        when(merchandiseRepository.findByProductName("Ferrari")).thenReturn((merchandise));
        FindMerchandiseReponse response = merchandinseApplicationMapper.merchandiseToFindMerchandiseResponse(merchandise);
        Assertions.assertEquals(findMerchandiseReponse.getQuantity(), response.getQuantity());
    }

    @Test
    void findNewMerchandise_givenadmissionDate_thenShouldReturnFindNewMerchandiseResponse() {
        merchandise = Merchandise.builder()
                .productName("Ferrari")
                .admissionDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .quantity(quantity)
                .userWhoRegisters(UserNexos.builder()
                        .id(ID)
                        .age(age)
                        .userType("administrador")
                        .userName("Miguel")
                        .addmisionUserDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        .build()
                )
                .build();
        findMerchandiseReponse = FindMerchandiseReponse.builder()
                .productName("Ferrari")
                .admissionDate("04/09/2023")
                .quantity(quantity)
                .userWhoRegisters("Miguel")
                .build();
        when(merchandiseRepository.findByProductName("04/09/2023")).thenReturn((merchandise));
        FindMerchandiseReponse response = merchandinseApplicationMapper.merchandiseToFindMerchandiseResponse(merchandise);
        Assertions.assertEquals(findMerchandiseReponse.getQuantity(), response.getQuantity());
    }
}

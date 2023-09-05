package com.inventario.nexos;

import com.inventario.nexos.domain.application.adapter.UserNexosNexosServiceImpl;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexos;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexosResponse;
import com.inventario.nexos.domain.application.dto.usernexos.FindNewUserNexosReponse;
import com.inventario.nexos.domain.application.mapper.UserNexosApplicationMapper;
import com.inventario.nexos.domain.application.ports.input.service.UserNexosService;
import com.inventario.nexos.domain.application.ports.output.repository.UserNexosRepository;
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
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class NexosApplicationTests {

	@Mock
	private UserNexosRepository userNexosRepository;
	@Autowired
	private UserNexosApplicationMapper userNexosApplicationMapper;
	private UserNexosService userNexosService;

	private UserNexos userNexos;
	private CreateNewUserNexos createNewUserNexos;
	private CreateNewUserNexosResponse createNewUserNexosResponse;

	private FindNewUserNexosReponse findNewUserNexosReponse;
	private final Integer ID = 1;
	private final String age = "17";
	private final String userType = "administrador";


	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		userNexosApplicationMapper = new UserNexosApplicationMapper();
		userNexosService = new UserNexosNexosServiceImpl(userNexosRepository,userNexosApplicationMapper);

	}
	@Test
	void createNewUserNexos() {
		createNewUserNexos = CreateNewUserNexos.builder()
				.userType(userType)
				.userName("Alejandro")
				.age(age)
				.build();
		userNexos=userNexos.builder()
				.id(1)
				.userType(userType)
				.addmisionUserDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.userName("Alejandro")
				.age(age)
				.build();
		createNewUserNexosResponse = createNewUserNexosResponse.builder()
				.userType(userType)
				.addmisionUserDate("04/09/2023")
				.userName("Alejandro")
				.age(age)
				.build();
		when(userNexosRepository.save(userNexos)).thenReturn(userNexos);
		CreateNewUserNexosResponse response = userNexosService.createUserNexos(createNewUserNexos);
		Assertions.assertEquals(response.getAddmisionUserDate(), createNewUserNexosResponse.getAddmisionUserDate());
	}

	@Test
	void findNewUser_givenId_thenShouldReturnFindNewUserNexosResponse(){
		userNexos = UserNexos.builder()

				.userType(userType)
				.userName("Alejandro")
				.addmisionUserDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.age(age)
				.build();
		findNewUserNexosReponse = FindNewUserNexosReponse.builder()

				.userType(userType)
				.addmisionUserDate("04/09/2023")
				.age(age)
				.userName("Alejandro")
				.build();
		when(userNexosRepository.findById(ID)).thenReturn(Optional.of(userNexos));
		FindNewUserNexosReponse response = userNexosApplicationMapper.userNexosToFindNewUserNexosResponse(userNexos);
		Assertions.assertEquals(findNewUserNexosReponse.getUserName(), response.getUserName());
	}

	@Test
	void findNewUser_givenUserName_thenShouldReturnFindNewUserNexosResponse(){
		userNexos = UserNexos.builder()
				.userType(userType)
				.userName("Alejandro")
				.addmisionUserDate(LocalDate.parse("04/09/2023",DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.age(age)
				.build();
		findNewUserNexosReponse = FindNewUserNexosReponse.builder()
				.userType(userType)
				.addmisionUserDate("04/09/2023")
				.age(age)
				.userName("Alejandro")
				.build();
		when(userNexosRepository.findByUserName("Alejandro")).thenReturn((userNexos));
		FindNewUserNexosReponse response = userNexosApplicationMapper.userNexosToFindNewUserNexosResponse(userNexos);
		Assertions.assertEquals(findNewUserNexosReponse.getUserName(), response.getUserName());
	}


}

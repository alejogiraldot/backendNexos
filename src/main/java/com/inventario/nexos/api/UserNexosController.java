package com.inventario.nexos.api;



import com.inventario.nexos.domain.application.dto.merchandise.FindMerchandiseReponse;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexos;
import com.inventario.nexos.domain.application.dto.usernexos.CreateNewUserNexosResponse;

import com.inventario.nexos.domain.application.dto.usernexos.FindNewUserNexosReponse;
import com.inventario.nexos.domain.application.ports.input.service.UserNexosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usernexos")
@CrossOrigin("*")
public class UserNexosController {
    public final UserNexosService userNexosService;

    public UserNexosController(UserNexosService userNexosService) {
        this.userNexosService = userNexosService;
    }

    @PostMapping
    public ResponseEntity<CreateNewUserNexosResponse> createUser(@RequestBody CreateNewUserNexos createNewUserNexos) {
        CreateNewUserNexosResponse user = userNexosService.createUserNexos(createNewUserNexos);
        return ResponseEntity.ok(user);
    }
    @GetMapping(value = "/{id-username}")
    public ResponseEntity<FindNewUserNexosReponse> findUserNexos(@PathVariable("id-username") Integer idUserNexos) {
        return ResponseEntity.ok(userNexosService.findUserNexosById(idUserNexos));
    }

    @GetMapping(value = "/findByName/{userName}")
    public ResponseEntity<FindNewUserNexosReponse> findByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(userNexosService.findUserNexosByName(userName));
    }
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<FindNewUserNexosReponse>> finAllUsers() {
        List<FindNewUserNexosReponse> userNexosReponses = userNexosService.findAllUserNexos();
        return ResponseEntity.ok(userNexosReponses);
    }
}

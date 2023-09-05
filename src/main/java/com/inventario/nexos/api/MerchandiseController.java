package com.inventario.nexos.api;

import com.inventario.nexos.domain.application.dto.merchandise.*;
import com.inventario.nexos.domain.application.ports.input.service.MerchandiseService;
import com.inventario.nexos.domain.application.ports.output.repository.MerchandiseRepository;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.entity.UserNexos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("merchandise")
public class MerchandiseController {

    private final MerchandiseService merchandiseService;

    public MerchandiseController( MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }

    @PostMapping
        public ResponseEntity<CreateMerchandiseResponse> createMerchandise(@RequestBody CreateNewMerchandise createNewMerchandise) {
        CreateMerchandiseResponse product = merchandiseService.createMerchandise(createNewMerchandise);
        return ResponseEntity.ok(product);
    }
    @GetMapping(value = "/{productName}")
    public ResponseEntity<FindMerchandiseReponse> findMerchandise(@PathVariable String productName) {
        return ResponseEntity.ok(merchandiseService.findByProductName(productName));
    }

    @GetMapping(value = "/findById/{id-merchandise}")
    public ResponseEntity<FindMerchandiseReponse> findMerchandise(@PathVariable("id-merchandise") Integer idMerchandise) {
        return ResponseEntity.ok(merchandiseService.findById(idMerchandise));
    }

    @DeleteMapping(value = "/{productId}/{userId}")
    public void deleteMerchandise(@PathVariable("productId") Integer id,@PathVariable("userId") Integer userId) {
        merchandiseService.deleteById(DeleteMerchandise.builder()
                        .id(id)
                        .userWhoRegisters(UserNexos.builder()
                                .id(userId)
                                .build())
                .build());
    }


    @PutMapping("{id-merchandise}")
    public ResponseEntity<UpdateMerchandiseResponse> updateMerchandise( @RequestBody UpdateMerchandiseRequest updateMerchandiseRequest, @PathVariable("id-merchandise") Integer id) {
        UpdateMerchandiseResponse product = merchandiseService.update(updateMerchandiseRequest,id);
        return ResponseEntity.ok(product);
    }
    @GetMapping(value = "/findByAdmissionDate/{admissionDate}")
    public ResponseEntity<List<FindMerchandiseReponse>> findByAdmissionDate(@PathVariable String admissionDate) {
        List<FindMerchandiseReponse> merchandises = merchandiseService.findByAdmissionDate(admissionDate);
        return ResponseEntity.ok(merchandises);
    }
}

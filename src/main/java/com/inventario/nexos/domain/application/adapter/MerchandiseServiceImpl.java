package com.inventario.nexos.domain.application.adapter;

import com.inventario.nexos.domain.application.dto.merchandise.*;
import com.inventario.nexos.domain.application.mapper.MerchandinseApplicationMapper;
import com.inventario.nexos.domain.application.ports.input.service.MerchandiseService;
import com.inventario.nexos.domain.application.ports.output.repository.MerchandiseRepository;
import com.inventario.nexos.domain.application.ports.output.repository.UserNexosRepository;
import com.inventario.nexos.domain.core.constant.ProductConstant;
import com.inventario.nexos.domain.core.entity.Merchandise;
import com.inventario.nexos.domain.core.exception.ProductBelowZeroException;
import com.inventario.nexos.domain.core.exception.ProductRepeatCreateException;
import com.inventario.nexos.domain.core.exception.UserNotMatchWithMerchandise;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseServiceImpl implements MerchandiseService {
    private final MerchandinseApplicationMapper merchandinseApplicationMapper;
    private final MerchandiseRepository merchandiseRepository;
    private final UserNexosRepository userNexosRepository;

    public MerchandiseServiceImpl(MerchandinseApplicationMapper merchandinseApplicationMapper, MerchandiseRepository merchandiseRepository, UserNexosRepository userNexosRepository) {
        this.merchandinseApplicationMapper = merchandinseApplicationMapper;
        this.merchandiseRepository = merchandiseRepository;
        this.userNexosRepository = userNexosRepository;
    }


    @Override
    public CreateMerchandiseResponse createMerchandise(@Valid CreateNewMerchandise createNewMerchandise) {
        Merchandise merchandise = merchandinseApplicationMapper.createNewMerchandiseToMerchandise(createNewMerchandise);

        merchandise.setAdmissionDate(LocalDate.now());

        if (merchandise.getQuantity() < 0 ){
            throw new ProductBelowZeroException(String.format(ProductConstant.INVALID_PRODUCT_VALUE));
        }

        try {
            merchandise = merchandiseRepository.save(merchandise);
        }catch (DataIntegrityViolationException e){
            throw new ProductRepeatCreateException(String.format(ProductConstant.INVALID_PRODUCT_NAME));
        }



        return merchandinseApplicationMapper.merchandiseToCreateMerchandiseResponse(Merchandise.builder()
                        .productName(merchandise.getProductName())
                        .quantity(merchandise.getQuantity())
                        .quantity(merchandise.getQuantity())
                        .admissionDate(merchandise.getAdmissionDate())
                        .userWhoRegisters(userNexosRepository.findById(merchandise.getUserWhoRegisters().getId()).orElseThrow())
                .build());
    }

    @Override
    public FindMerchandiseReponse findByProductName(String productName) {
        return merchandinseApplicationMapper.merchandiseToFindMerchandiseResponse(merchandiseRepository.findByProductName((productName)));
    }

    @Override
    public void deleteById(DeleteMerchandise deleteMerchandise) {
        Merchandise merchandise = merchandiseRepository.findById(deleteMerchandise.getId()).orElseThrow();
        if(merchandise.getUserWhoRegisters().getId() == deleteMerchandise.getUserWhoRegisters().getId()){
            merchandiseRepository.deleteById(merchandise.getId());
        }else{
            throw new UserNotMatchWithMerchandise(String.format(ProductConstant.INVALID_PRODUCT_MATCH));
        }

    }
    @Override
    public FindMerchandiseReponse findById(Integer id) {
        return merchandinseApplicationMapper.merchandiseToFindMerchandiseResponse(merchandiseRepository.findById(id).orElseThrow());
    }

    @Override
    public UpdateMerchandiseResponse update(UpdateMerchandiseRequest updateMerchandiseRequest, Integer id) {
        Merchandise merchandise = merchandiseRepository.findById(id).orElseThrow();
        merchandiseRepository.update(
                Merchandise.builder()
                        .id(id)
                        .quantity(updateMerchandiseRequest.getQuantity())
                        .productName(updateMerchandiseRequest.getProductName())
                        .admissionDate(merchandise.getAdmissionDate())
                        .userWhoRegisters(merchandise.getUserWhoRegisters())
                        .build()
        );
        return null;
    }

    @Override
    public List<FindMerchandiseReponse> findByAdmissionDate(String admissionDate) {
        List<Merchandise> findMerchandiseReponses = merchandiseRepository.findByAdmissionDate(admissionDate);
        return merchandinseApplicationMapper.merchadinseListToFindMerchadinseResponsesList(findMerchandiseReponses);
    }


}

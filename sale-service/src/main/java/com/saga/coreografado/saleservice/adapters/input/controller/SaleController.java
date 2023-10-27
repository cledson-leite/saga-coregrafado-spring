package com.saga.coreografado.saleservice.adapters.input.controller;

import com.saga.coreografado.saleservice.adapters.input.controller.mapper.SaleRequestMapper;
import com.saga.coreografado.saleservice.adapters.input.controller.request.SaleRequest;
import com.saga.coreografado.saleservice.application.core.domain.Sale;
import com.saga.coreografado.saleservice.application.ports.input.CreateSaleInput;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {
    @Autowired
    private CreateSaleInput createSaleInput;
    @Autowired
    private SaleRequestMapper saleRequestMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest saleRequest){
        log.info("Criando a venda ...");
        Sale sale = saleRequestMapper.toSale(saleRequest);
        createSaleInput.create(sale);
        log.info("Venda criada com sucesso!");
    }
}

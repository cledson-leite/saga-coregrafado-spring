package com.saga.coreografado.saleservice.config.usecase;

import com.saga.coreografado.saleservice.adapters.output.SaveSaleAdapter;
import com.saga.coreografado.saleservice.adapters.output.SendCreatedSaleAdapter;
import com.saga.coreografado.saleservice.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;

public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter
    ){
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}

package com.saga.coreografado.saleservice.config.usecase;

import com.saga.coreografado.saleservice.adapters.output.FindSaleByIdAdapter;
import com.saga.coreografado.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {
    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
            FindSaleByIdAdapter findSaleByIdAdapter
    ){
        return new FindSaleByIdUseCase(
                findSaleByIdAdapter
        );
    }
}

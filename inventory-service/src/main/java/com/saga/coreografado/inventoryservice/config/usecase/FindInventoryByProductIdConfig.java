package com.saga.coreografado.inventoryservice.config.usecase;

import com.saga.coreografado.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import com.saga.coreografado.inventoryservice.application.ports.output.FindInventoryByProductIdOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {
    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdOutput findInventoryByProductIdOutput
    ){
        return new FindInventoryByProductIdUseCase(
                findInventoryByProductIdOutput
        );
    }
}

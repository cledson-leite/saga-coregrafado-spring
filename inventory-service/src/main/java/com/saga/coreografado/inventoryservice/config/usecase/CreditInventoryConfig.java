package com.saga.coreografado.inventoryservice.config.usecase;

import com.saga.coreografado.inventoryservice.adapters.output.SendToKafkaAdapter;
import com.saga.coreografado.inventoryservice.adapters.output.UpdateInventoryAdapter;
import com.saga.coreografado.inventoryservice.application.core.usecase.CreditInventoryUseCase;
import com.saga.coreografado.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ){
        return new CreditInventoryUseCase(
                findInventoryByProductIdUseCase,
                updateInventoryAdapter,
                sendToKafkaAdapter
        );
    }
}

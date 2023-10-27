package com.saga.coreografado.inventoryservice.config.usecase;

import com.saga.coreografado.inventoryservice.adapters.output.UpdateInventoryAdapter;
import com.saga.coreografado.inventoryservice.application.core.usecase.DebitInventoryUseCase;
import com.saga.coreografado.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import com.saga.coreografado.inventoryservice.application.ports.output.SendUpdatedInventoryOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendUpdatedInventoryOutput sendUpdatedInventoryOutput
    ){
        return new DebitInventoryUseCase(
                findInventoryByProductIdUseCase,
                updateInventoryAdapter,
                sendUpdatedInventoryOutput
        );
    }
}

package com.saga.coreografado.paymentservice.config.usecase;

import com.saga.coreografado.paymentservice.adapter.output.SavePaymentAdapter;
import com.saga.coreografado.paymentservice.adapter.output.SendToKafkaAdapter;
import com.saga.coreografado.paymentservice.adapter.output.UpdateUserAdapter;
import com.saga.coreografado.paymentservice.application.core.usecase.FindUserByIdUseCase;
import com.saga.coreografado.paymentservice.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {
    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ){
        return new SalePaymentUseCase(
                findUserByIdUseCase,
                updateUserAdapter,
                savePaymentAdapter,
                sendToKafkaAdapter
        );
    }
}

package com.saga.coreografado.paymentservice.config.usecase;

import com.saga.coreografado.paymentservice.adapter.output.FindUserByIdAdapter;
import com.saga.coreografado.paymentservice.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {
    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(
            FindUserByIdAdapter findUserByIdAdapter
    ){
        return new FindUserByIdUseCase(
                findUserByIdAdapter
        );
    }
}

package com.saga.coreografado.paymentservice.adapter.output.repository.mapper;

import com.saga.coreografado.paymentservice.adapter.output.repository.entity.PaymentEntity;
import com.saga.coreografado.paymentservice.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {
    PaymentEntity toPaymentEntity(Payment payment);
}

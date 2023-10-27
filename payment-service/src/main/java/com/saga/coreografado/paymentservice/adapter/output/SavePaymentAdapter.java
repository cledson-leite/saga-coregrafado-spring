package com.saga.coreografado.paymentservice.adapter.output;

import com.saga.coreografado.paymentservice.adapter.output.repository.PaymentRepository;
import com.saga.coreografado.paymentservice.adapter.output.repository.entity.PaymentEntity;
import com.saga.coreografado.paymentservice.adapter.output.repository.mapper.PaymentEntityMapper;
import com.saga.coreografado.paymentservice.application.core.domain.Payment;
import com.saga.coreografado.paymentservice.application.ports.output.SavePaymentOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentAdapter implements SavePaymentOutput {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        PaymentEntity paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }
}

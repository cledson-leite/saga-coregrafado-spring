package com.saga.coreografado.paymentservice.application.ports.output;

import com.saga.coreografado.paymentservice.application.core.domain.Payment;

public interface SavePaymentOutput {
    void save(Payment payment);
}

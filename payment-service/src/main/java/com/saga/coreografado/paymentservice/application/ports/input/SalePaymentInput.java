package com.saga.coreografado.paymentservice.application.ports.input;

import com.saga.coreografado.paymentservice.application.core.domain.Sale;

public interface SalePaymentInput {
    void payment(Sale sale);
}

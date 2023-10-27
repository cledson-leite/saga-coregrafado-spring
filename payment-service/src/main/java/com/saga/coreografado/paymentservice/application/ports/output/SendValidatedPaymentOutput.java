package com.saga.coreografado.paymentservice.application.ports.output;

import com.saga.coreografado.paymentservice.application.core.domain.Sale;
import com.saga.coreografado.paymentservice.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOutput {
    void send(Sale sale, SaleEvent event);
}

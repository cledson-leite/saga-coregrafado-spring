package com.saga.coreografado.saleservice.application.ports.input;

import com.saga.coreografado.saleservice.application.core.domain.Sale;

public interface CancelSaleInput {
    void cancel(Sale sale);
}

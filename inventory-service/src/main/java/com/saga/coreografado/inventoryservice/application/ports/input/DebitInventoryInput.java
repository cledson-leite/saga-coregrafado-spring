package com.saga.coreografado.inventoryservice.application.ports.input;

import com.saga.coreografado.inventoryservice.application.core.domain.Sale;

public interface DebitInventoryInput {
    void debit(Sale sale);
}

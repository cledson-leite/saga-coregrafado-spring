package com.saga.coreografado.inventoryservice.application.ports.input;

import com.saga.coreografado.inventoryservice.application.core.domain.Sale;

public interface CreditInventoryInput {
    void credit(Sale sale);
}

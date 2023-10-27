package com.saga.coreografado.inventoryservice.application.ports.output;

import com.saga.coreografado.inventoryservice.application.core.domain.Sale;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;

public interface SendUpdatedInventoryOutput {
    void send(Sale sale, SaleEvent event);
}

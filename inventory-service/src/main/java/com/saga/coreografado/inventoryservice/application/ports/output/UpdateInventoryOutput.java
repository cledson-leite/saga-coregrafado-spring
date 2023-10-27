package com.saga.coreografado.inventoryservice.application.ports.output;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;

public interface UpdateInventoryOutput {
    void update(Inventory inventory);
}

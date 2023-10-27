package com.saga.coreografado.inventoryservice.application.ports.input;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;

public interface FindInventoryByProductIdInput {
    Inventory find(Integer productId);
}

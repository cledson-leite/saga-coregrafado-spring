package com.saga.coreografado.inventoryservice.application.ports.output;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutput {

    Optional<Inventory> find(final Integer productId);
}

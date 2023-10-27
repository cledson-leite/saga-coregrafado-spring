package com.saga.coreografado.inventoryservice.adapters.output.repository.mapper;

import com.saga.coreografado.inventoryservice.adapters.output.repository.entity.InventoryEntity;
import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {
    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);
}

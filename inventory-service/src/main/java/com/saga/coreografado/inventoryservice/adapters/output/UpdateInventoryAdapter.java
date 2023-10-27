package com.saga.coreografado.inventoryservice.adapters.output;

import com.saga.coreografado.inventoryservice.adapters.output.repository.InventoryRepository;
import com.saga.coreografado.inventoryservice.adapters.output.repository.entity.InventoryEntity;
import com.saga.coreografado.inventoryservice.adapters.output.repository.mapper.InventoryEntityMapper;
import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;
import com.saga.coreografado.inventoryservice.application.ports.output.UpdateInventoryOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutput {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        InventoryEntity inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);

    }
}

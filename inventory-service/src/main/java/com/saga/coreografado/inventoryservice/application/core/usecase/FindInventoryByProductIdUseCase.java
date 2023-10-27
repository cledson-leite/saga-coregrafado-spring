package com.saga.coreografado.inventoryservice.application.core.usecase;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;
import com.saga.coreografado.inventoryservice.application.ports.input.FindInventoryByProductIdInput;
import com.saga.coreografado.inventoryservice.application.ports.output.FindInventoryByProductIdOutput;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInput {
    private final FindInventoryByProductIdOutput findInventoryByProductIdOutput;

    public FindInventoryByProductIdUseCase(
            FindInventoryByProductIdOutput findInventoryByProductIdOutput
    ) {
        this.findInventoryByProductIdOutput = findInventoryByProductIdOutput;
    }

    @Override
    public Inventory find(Integer productId){
        return findInventoryByProductIdOutput.find(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque"));
    }
}

package com.saga.coreografado.inventoryservice.application.core.usecase;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;
import com.saga.coreografado.inventoryservice.application.core.domain.Sale;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.inventoryservice.application.ports.input.DebitInventoryInput;
import com.saga.coreografado.inventoryservice.application.ports.input.FindInventoryByProductIdInput;
import com.saga.coreografado.inventoryservice.application.ports.output.SendUpdatedInventoryOutput;
import com.saga.coreografado.inventoryservice.application.ports.output.UpdateInventoryOutput;

public class DebitInventoryUseCase implements DebitInventoryInput {
    private final FindInventoryByProductIdInput findInventoryByProductIdInput;
    private final UpdateInventoryOutput updateInventoryOutput;
    private final SendUpdatedInventoryOutput sendUpdatedInventoryOutput;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInput findInventoryByProductIdInput,
            UpdateInventoryOutput updateInventoryOutput,
            SendUpdatedInventoryOutput sendUpdatedInventoryOutput
    ) {
        this.findInventoryByProductIdInput = findInventoryByProductIdInput;
        this.updateInventoryOutput = updateInventoryOutput;
        this.sendUpdatedInventoryOutput = sendUpdatedInventoryOutput;
    }

    @Override
    public void debit(Sale sale){
        Inventory inventory = findInventoryByProductIdInput.find(sale.getProductId());
        if(inventory.getQuantity() < sale.getQuantity()){
            throw new RuntimeException("Estoque insuficiente");
        }
        inventory.debitQuantity(sale.getQuantity());
        updateInventoryOutput.update(inventory);
        sendUpdatedInventoryOutput.send(sale, SaleEvent.UPDATED_INVENTORY);
    }
}

package com.saga.coreografado.inventoryservice.application.core.usecase;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;
import com.saga.coreografado.inventoryservice.application.core.domain.Sale;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.inventoryservice.application.ports.input.CreditInventoryInput;
import com.saga.coreografado.inventoryservice.application.ports.input.FindInventoryByProductIdInput;
import com.saga.coreografado.inventoryservice.application.ports.output.SendToKafkaOutput;
import com.saga.coreografado.inventoryservice.application.ports.output.UpdateInventoryOutput;

public class CreditInventoryUseCase implements CreditInventoryInput {
    private final FindInventoryByProductIdInput findInventoryByProductIdInput;
    private final UpdateInventoryOutput updateInventoryOutput;
    private final SendToKafkaOutput sendToKafkaOutput;

    public CreditInventoryUseCase(
            FindInventoryByProductIdInput findInventoryByProductIdInput,
            UpdateInventoryOutput updateInventoryOutput,
            SendToKafkaOutput sendToKafkaOutput
    ) {
        this.findInventoryByProductIdInput = findInventoryByProductIdInput;
        this.updateInventoryOutput = updateInventoryOutput;
        this.sendToKafkaOutput = sendToKafkaOutput;
    }

    @Override
    public void credit(Sale sale){
        Inventory inventory = findInventoryByProductIdInput.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutput.update(inventory);
        sendToKafkaOutput.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}

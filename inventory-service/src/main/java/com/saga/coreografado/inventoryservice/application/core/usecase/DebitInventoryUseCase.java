package com.saga.coreografado.inventoryservice.application.core.usecase;

import com.saga.coreografado.inventoryservice.application.core.domain.Inventory;
import com.saga.coreografado.inventoryservice.application.core.domain.Sale;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.inventoryservice.application.ports.input.DebitInventoryInput;
import com.saga.coreografado.inventoryservice.application.ports.input.FindInventoryByProductIdInput;
import com.saga.coreografado.inventoryservice.application.ports.output.SendToKafkaOutput;
import com.saga.coreografado.inventoryservice.application.ports.output.UpdateInventoryOutput;

public class DebitInventoryUseCase implements DebitInventoryInput {
    private final FindInventoryByProductIdInput findInventoryByProductIdInput;
    private final UpdateInventoryOutput updateInventoryOutput;
    private final SendToKafkaOutput sendToKafkaOutput;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInput findInventoryByProductIdInput,
            UpdateInventoryOutput updateInventoryOutput,
            SendToKafkaOutput sendToKafkaOutput
    ) {
        this.findInventoryByProductIdInput = findInventoryByProductIdInput;
        this.updateInventoryOutput = updateInventoryOutput;
        this.sendToKafkaOutput = sendToKafkaOutput;
    }

    @Override
    public void debit(Sale sale) {
        try {
            Inventory inventory = findInventoryByProductIdInput.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente");
            }
            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutput.update(inventory);
            sendToKafkaOutput.send(sale, SaleEvent.UPDATED_INVENTORY);
        }catch (Exception exception){
            sendToKafkaOutput.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }
}

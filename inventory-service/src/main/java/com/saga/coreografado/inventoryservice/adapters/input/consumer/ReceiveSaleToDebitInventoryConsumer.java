package com.saga.coreografado.inventoryservice.adapters.input.consumer;

import com.saga.coreografado.inventoryservice.adapters.output.message.SaleMessage;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.inventoryservice.application.ports.input.DebitInventoryInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInput debitInventoryInput;

    @KafkaListener(topics = "saga-sale", groupId = "inventory-debit")
    public void received(SaleMessage saleMessage){
        if (SaleEvent.CREATED_SALE.equals(saleMessage.getEvent())){
            log.info("Iniciando separação de mercadoria ...");
            debitInventoryInput.debit(saleMessage.getSale());
            log.info("Mercadoria separada");
        }
    }
}

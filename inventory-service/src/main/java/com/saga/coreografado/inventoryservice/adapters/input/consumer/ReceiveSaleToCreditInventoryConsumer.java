package com.saga.coreografado.inventoryservice.adapters.input.consumer;

import com.saga.coreografado.inventoryservice.adapters.output.message.SaleMessage;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.inventoryservice.application.ports.input.CreditInventoryInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    @Autowired
    private CreditInventoryInput creditInventoryInput;

    @KafkaListener(topics = "saga-sale", groupId = "inventory-credit")
    public void received(SaleMessage saleMessage){
        if (SaleEvent.FAILED_PAYMENT.equals(saleMessage.getEvent())){
            log.info("Iniciando estorno da mercadoria ...");
            creditInventoryInput.credit(saleMessage.getSale());
            log.info("Mercadoria retornada ao estoque");
        }
    }
}

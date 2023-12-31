package com.saga.coreografado.inventoryservice.adapters.output;

import com.saga.coreografado.inventoryservice.adapters.output.message.SaleMessage;
import com.saga.coreografado.inventoryservice.application.core.domain.Sale;
import com.saga.coreografado.inventoryservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.inventoryservice.application.ports.output.SendToKafkaOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class SendToKafkaAdapter implements SendToKafkaOutput {

    @Autowired
    KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        SaleMessage saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("saga-sale", saleMessage);
    }
}

package com.saga.coreografado.paymentservice.adapter.output;

import com.saga.coreografado.paymentservice.adapter.output.message.SaleMessage;
import com.saga.coreografado.paymentservice.application.core.domain.Sale;
import com.saga.coreografado.paymentservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.paymentservice.application.ports.output.SendValidatedPaymentOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendValidatedPaymentAdapter implements SendValidatedPaymentOutput {

   @Autowired
    KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        SaleMessage saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("saga-sale", saleMessage);
    }
}

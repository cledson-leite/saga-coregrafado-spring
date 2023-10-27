package com.saga.coreografado.saleservice.adapters.input.consumer;

import com.saga.coreografado.saleservice.adapters.output.message.SaleMessage;
import com.saga.coreografado.saleservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.saleservice.application.ports.input.FinalizeSaleInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FinalizeSaleConsumer {

    @Autowired
    private FinalizeSaleInput finalizeSaleInput;

    @KafkaListener(topics = "sage-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.getEvent())){
            log.info("Iniciando finalizaçãode venda ...");
            finalizeSaleInput.finalize(saleMessage.getSale());
            log.info("Venda finalizada com sucesso!");
        }
    }
}

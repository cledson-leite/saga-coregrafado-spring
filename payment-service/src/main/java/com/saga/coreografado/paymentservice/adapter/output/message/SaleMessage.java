package com.saga.coreografado.paymentservice.adapter.output.message;

import com.saga.coreografado.paymentservice.application.core.domain.Sale;
import com.saga.coreografado.paymentservice.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {
    private Sale sale;
    private SaleEvent event;
}

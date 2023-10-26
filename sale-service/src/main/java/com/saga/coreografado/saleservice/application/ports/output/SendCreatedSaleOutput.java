package com.saga.coreografado.saleservice.application.ports.output;

import com.saga.coreografado.saleservice.application.core.domain.Sale;
import com.saga.coreografado.saleservice.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutput {
    void send(Sale sale, SaleEvent event);
}

package com.saga.coreografado.saleservice.application.ports.output;

import com.saga.coreografado.saleservice.application.core.domain.Sale;

public interface SaveSaleOutput {
    Sale save(Sale sale);
}

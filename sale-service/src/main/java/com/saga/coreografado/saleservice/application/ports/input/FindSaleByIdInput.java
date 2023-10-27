package com.saga.coreografado.saleservice.application.ports.input;

import com.saga.coreografado.saleservice.application.core.domain.Sale;

public interface FindSaleByIdInput {
    Sale find(final Integer id);
}

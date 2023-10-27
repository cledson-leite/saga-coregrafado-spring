package com.saga.coreografado.saleservice.application.ports.output;

import com.saga.coreografado.saleservice.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutput {
    Optional<Sale> find(final Integer id);
}

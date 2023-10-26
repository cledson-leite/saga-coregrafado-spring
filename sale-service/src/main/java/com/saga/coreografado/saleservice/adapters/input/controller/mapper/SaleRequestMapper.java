package com.saga.coreografado.saleservice.adapters.input.controller.mapper;

import com.saga.coreografado.saleservice.adapters.input.controller.request.SaleRequest;
import com.saga.coreografado.saleservice.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {
    Sale toSale(SaleRequest saleRequest);
}

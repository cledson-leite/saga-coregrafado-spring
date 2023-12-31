package com.saga.coreografado.saleservice.application.core.usecase;

import com.saga.coreografado.saleservice.application.core.domain.Sale;
import com.saga.coreografado.saleservice.application.ports.input.FindSaleByIdInput;
import com.saga.coreografado.saleservice.application.ports.output.FindSaleByIdOutput;

public class FindSaleByIdUseCase implements FindSaleByIdInput {

    private final FindSaleByIdOutput findSaleByIdOutput;

    public FindSaleByIdUseCase(FindSaleByIdOutput findSaleByIdOutput) {
        this.findSaleByIdOutput = findSaleByIdOutput;
    }

    @Override
    public Sale find(final Integer id){
        return findSaleByIdOutput.find(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }
}

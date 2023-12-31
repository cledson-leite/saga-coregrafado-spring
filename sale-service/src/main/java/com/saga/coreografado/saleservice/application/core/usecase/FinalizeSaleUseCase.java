package com.saga.coreografado.saleservice.application.core.usecase;

import com.saga.coreografado.saleservice.application.core.domain.Sale;
import com.saga.coreografado.saleservice.application.core.domain.enums.SaleStatus;
import com.saga.coreografado.saleservice.application.ports.input.FinalizeSaleInput;
import com.saga.coreografado.saleservice.application.ports.input.FindSaleByIdInput;
import com.saga.coreografado.saleservice.application.ports.output.SaveSaleOutput;

public class FinalizeSaleUseCase implements FinalizeSaleInput {

    private final FindSaleByIdInput findSaleByIdInput;
    private final SaveSaleOutput saveSaleOutput;

    public FinalizeSaleUseCase(
            FindSaleByIdInput findSaleByIdInput,
            SaveSaleOutput saveSaleOutput
    ) {
        this.findSaleByIdInput = findSaleByIdInput;
        this.saveSaleOutput = saveSaleOutput;
    }

    @Override
    public void finalize(Sale sale) {
        Sale saleResponse = findSaleByIdInput.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutput.save(saleResponse);
    }
}

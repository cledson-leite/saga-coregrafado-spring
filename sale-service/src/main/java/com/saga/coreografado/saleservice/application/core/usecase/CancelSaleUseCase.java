package com.saga.coreografado.saleservice.application.core.usecase;

import com.saga.coreografado.saleservice.application.core.domain.Sale;
import com.saga.coreografado.saleservice.application.core.domain.enums.SaleStatus;
import com.saga.coreografado.saleservice.application.ports.input.CancelSaleInput;
import com.saga.coreografado.saleservice.application.ports.input.FindSaleByIdInput;
import com.saga.coreografado.saleservice.application.ports.output.SaveSaleOutput;

public class CancelSaleUseCase implements CancelSaleInput {
    private final SaveSaleOutput saveSaleOutput;
    private final FindSaleByIdInput findSaleByIdInput;

    public CancelSaleUseCase(
            SaveSaleOutput saveSaleOutput,
            FindSaleByIdInput findSaleByIdInput) {
        this.saveSaleOutput = saveSaleOutput;
        this.findSaleByIdInput = findSaleByIdInput;
    }

    @Override
    public void cancel(Sale sale){
        Sale saleResponse = findSaleByIdInput.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutput.save(saleResponse);
    }
}

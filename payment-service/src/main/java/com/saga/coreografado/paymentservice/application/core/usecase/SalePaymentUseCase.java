package com.saga.coreografado.paymentservice.application.core.usecase;

import com.saga.coreografado.paymentservice.application.core.domain.Payment;
import com.saga.coreografado.paymentservice.application.core.domain.Sale;
import com.saga.coreografado.paymentservice.application.core.domain.User;
import com.saga.coreografado.paymentservice.application.core.domain.enums.SaleEvent;
import com.saga.coreografado.paymentservice.application.ports.input.FindUserByIdInput;
import com.saga.coreografado.paymentservice.application.ports.input.SalePaymentInput;
import com.saga.coreografado.paymentservice.application.ports.output.SavePaymentOutput;
import com.saga.coreografado.paymentservice.application.ports.output.SendValidatedPaymentOutput;
import com.saga.coreografado.paymentservice.application.ports.output.UpdateUserOutput;

public class SalePaymentUseCase implements SalePaymentInput {
    private final FindUserByIdInput findUserByIdInput;
    private final UpdateUserOutput updateUserOutput;
    private final SavePaymentOutput savePaymentOutput;
    private final SendValidatedPaymentOutput sendValidatedPaymentOutput;

    public SalePaymentUseCase(
            FindUserByIdInput findUserByIdInput,
            UpdateUserOutput updateUserOutput,
            SavePaymentOutput savePaymentOutput,
            SendValidatedPaymentOutput sendValidatedPaymentOutput
    ) {
        this.findUserByIdInput = findUserByIdInput;
        this.updateUserOutput = updateUserOutput;
        this.savePaymentOutput = savePaymentOutput;
        this.sendValidatedPaymentOutput = sendValidatedPaymentOutput;
    }

    @Override
    public void payment(Sale sale){
        User user = findUserByIdInput.find(sale.getUserId());
        if(user.getBalance().compareTo(sale.getValue()) < 0){
            throw new RuntimeException("Saldo insuficiente!");
        }
        user.debitBalance(sale.getValue());
        updateUserOutput.update(user);
        Payment newPayment = new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
        savePaymentOutput.save(newPayment);
        sendValidatedPaymentOutput.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }
}

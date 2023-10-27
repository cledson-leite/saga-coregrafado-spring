package com.saga.coreografado.paymentservice.application.ports.output;

import com.saga.coreografado.paymentservice.application.core.domain.User;

public interface UpdateUserOutput {
    void update(User user);
}

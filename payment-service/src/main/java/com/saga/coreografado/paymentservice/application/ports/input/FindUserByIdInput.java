package com.saga.coreografado.paymentservice.application.ports.input;

import com.saga.coreografado.paymentservice.application.core.domain.User;

public interface FindUserByIdInput {
    User find(final Integer id);
}

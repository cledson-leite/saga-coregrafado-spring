package com.saga.coreografado.paymentservice.application.ports.output;

import com.saga.coreografado.paymentservice.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutput {
    Optional<User> find(Integer userId);
}

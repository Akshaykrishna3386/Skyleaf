package com.getPaymentMethod.Repository;

import org.springframework.data.repository.CrudRepository;

import com.getPaymentMethod.Bean.PaymentMethod;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Integer> {

}

package com.dxctraining.consumer.service;

import com.dxctraining.consumer.entities.Consumer;

public interface IConsumerService {
    Consumer addConsumer(Consumer consumer);
    Consumer ConsumerById(int id);
}

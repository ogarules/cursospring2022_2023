package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor1 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 1 before initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;

            log.info("Worker name {}", worker.getName());

            worker.setName("Otro oga mas");

            log.info("Worker name {}", worker.getName());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 1 after initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;

            log.info("Worker name {}", worker.getName());

            worker.setName("Otro oga mas after");

            log.info("Worker name {}", worker.getName());
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
    
}

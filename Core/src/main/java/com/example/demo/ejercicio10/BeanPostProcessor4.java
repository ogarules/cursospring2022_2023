package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor4 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 4 before initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 4 after initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;
            WorkerFacade facade = new WorkerFacade();
            facade.setOriginalWorker(worker);

            log.info("Worker name {} after", worker.getName());

            facade.setName("otro oga mas facade");

            log.info("Worker name {} after", worker.getName());

            bean = facade;
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 3;
    }
}


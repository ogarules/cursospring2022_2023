package com.example.demo.ejercicio5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomScope implements Scope {
    
    private Map<String, Object> objectMap = Collections.synchronizedMap(new HashMap<String, Object>());

    private int n = 0;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        log.info("Bean solicitado...");

        if (n >= 5) {
            log.info("Limpiando beans...");
            this.objectMap.clear();
            n = 0;
        }

        if (!this.objectMap.containsKey(name)) {
            log.info("Construyendo bean...");
            Object bean = objectFactory.getObject();
            this.objectMap.put(name, bean);
        }

        n++;

        return this.objectMap.get(name);
    }

    @Override
    @Nullable
    public Object remove(String name) {
        return this.objectMap.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
                
    }

    @Override
    @Nullable
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    @Nullable
    public String getConversationId() {
        return "CustomScope";
    }


}

package com.example.demo.ejercicio20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio20/beans.xml" })
public class ResourcesTests {

    @Autowired 
    private Resources resources;

    @SneakyThrows
    @Test
    public void resourcesTest() {

        log.info("Testing resources...");

        ResourceLoadrUtils.loadTesxtResourceTest(resources.getTxtFile());
        ResourceLoadrUtils.loadPropertiesTest(resources.getPropertiesFile());
        ResourceLoadrUtils.urlResourceTest(resources.getUrlFile());
        ResourceLoadrUtils.imageResourceCopyTest(resources.getImageFile(),"src/main/resources/spring/ejercicio20/copy-filesystem/");
    }
}

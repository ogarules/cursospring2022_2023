package com.example.demo.ejercicio4;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieFinderTests {
    
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio4/beans.xml");
    }

    @Test
    public void findMovieTest() {
        log.info("Finding movie...");

        MovieListener listener = (MovieListener) context.getBean("movieListener");
        Movie movie = listener.buscarPelicula("titanic");

        assertEquals("titanic", movie.getTitulo());
    }
}

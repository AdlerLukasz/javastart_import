package pl.javastart.example;

import static org.junit.Assert.fail;

import org.junit.Test;

public class HelloTest {

    @Test
    public void testSayHello() {
        Hello hello = new Hello();
        hello.sayHello();
    }

}

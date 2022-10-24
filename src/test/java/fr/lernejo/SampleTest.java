package fr.lernejo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static fr.lernejo.Sample.Operation.ADD;
import static fr.lernejo.Sample.Operation.MULT;
import static org.junit.jupiter.api.Assertions.*;

class SampleTest {
    Sample sample = new Sample();
    @Test
    void testADD(){
        Assertions.assertEquals(sample.op(ADD, 2, 2), 4);
    }
    @Test
    void testMULT(){
        Assertions.assertEquals(sample.op(MULT, 2, 5),10);
    }
    @Test
    void testNullFact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sample.fact(-3));
    }
    @Test
    void testFactIfNEqualsZero() {
        Assertions.assertEquals(sample.fact(0), 1);
    }
}

package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTest {
    @Test
    public void testCalculation() {
        Assertions.assertEquals(6.0, new Triangle(3, 4, 5).getArea());
        Assertions.assertEquals(12.0, new Triangle(3, 4, 5).getPerimeter());
        Assertions.assertEquals(0.0, new Triangle(0, 0, 0).getPerimeter());
        Assertions.assertEquals(0.0, new Triangle(0, 0, 0).getArea());
    }

    @Test
    public void testNegativeCalculation() {
        Assertions.assertNotEquals(5.0, new Triangle(3, 4, 5).getArea());
        Assertions.assertNotEquals(13.0, new Triangle(3, 4, 5).getPerimeter());
        Assertions.assertNotEquals(5.0, new Triangle(0, 0, 0).getArea());
        Assertions.assertNotEquals(5.0, new Triangle(0, 0, 0).getPerimeter());
    }
}

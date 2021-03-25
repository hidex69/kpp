package com.example.restservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    public void testCalculation() {
        assertEquals(6.0, new Triangle(3, 4, 5).getArea());
        assertEquals(12.0, new Triangle(3, 4, 5).getPerimeter());
        assertEquals(0.0, new Triangle(0, 0, 0).getPerimeter());
        assertEquals(0.0, new Triangle(0, 0, 0).getArea());
    }
}

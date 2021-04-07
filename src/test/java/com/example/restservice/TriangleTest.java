package com.example.restservice;

import com.example.restservice.model.RequestResult;
import com.example.restservice.model.Triangle;
import com.example.restservice.service.TriangleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTest {
    @Test
    public void testCalculation() {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(0, 0, 0);

        Assertions.assertEquals(6.0, new RequestResult(TriangleService.area(triangle1),
                TriangleService.perimeter(triangle1)).getArea());
        Assertions.assertEquals(12.0, new RequestResult(TriangleService.area(triangle1),
                TriangleService.perimeter(triangle1)).getPerimeter());
        Assertions.assertEquals(0, new RequestResult(TriangleService.area(triangle2),
                TriangleService.perimeter(triangle2)).getPerimeter());
        Assertions.assertEquals(0.0, new RequestResult(TriangleService.area(triangle2),
                TriangleService.perimeter(triangle2)).getArea());
    }

    @Test
    public void testNegativeCalculation() {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(0, 0, 0);

        Assertions.assertNotEquals(13.0, new RequestResult(TriangleService.area(triangle1),
                TriangleService.perimeter(triangle1)).getPerimeter());
        Assertions.assertNotEquals(1.0, new RequestResult(TriangleService.area(triangle2),
                TriangleService.perimeter(triangle2)).getPerimeter());
        Assertions.assertNotEquals(5.0, new RequestResult(TriangleService.area(triangle1),
                TriangleService.perimeter(triangle1)).getArea());
        Assertions.assertNotEquals(12.0, new RequestResult(TriangleService.area(triangle2),
                TriangleService.perimeter(triangle2)).getArea());
    }
}

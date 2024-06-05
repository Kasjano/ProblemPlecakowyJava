package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ProblemTest {

    @Test
    void testCoNajmniejJedenSpelniaOgraniczenia() {
        Problem problem = new Problem(0, 1, 1, 10);
        problem.AddItemManually(1, 10, 5);
        Result result = problem.Solve(7);
        assertFalse(result.numbers.isEmpty());
    }

    @Test
    void testZadenNieSpelniaOgraniczen() {
        Problem problem = new Problem(0, 1, 1, 10);
        problem.AddItemManually(1, 5, 5);
        Result result = problem.Solve(3);
        assertTrue(result.numbers.isEmpty());
    }

    @Test
    void testCzyWszystkiePrzedmiotyMieszczaSie() {
        Problem problem = new Problem(0, 1, 1, 10);
        problem.AddItemManually(1, 10, 15);
        problem.AddItemManually(2, 4, 8);
        Result result = problem.Solve(20);
        assertTrue(result.totalWeight<=20);
    }

    @Test
    void testSprawdzenieWagiIWartosci() {
        Problem problem = new Problem(0, 1, 1, 10);
        problem.AddItemManually(1, 10, 8);
        problem.AddItemManually(2, 4, 4);
        problem.AddItemManually(3, 5, 10);
        Result result = problem.Solve(15);
        assertEquals(14, result.totalValue);
        assertEquals(12, result.totalWeight);
        assertEquals(Arrays.asList(1, 2), result.numbers);
    }

    @Test
    void testCzyKolejnoscPrzedmiotowWplywaNaRozwiazanie()
    {
        Problem problem = new Problem(0, 1,1,10);
        Problem problem2 = new Problem(0, 1,1,10);
        problem.AddItemManually(1, 2, 2);
        problem.AddItemManually(2, 4, 5);
        problem.AddItemManually(3, 2, 3);
        problem2.AddItemManually(1, 4, 5);
        problem2.AddItemManually(2, 2, 3);
        problem2.AddItemManually(3, 2, 2);
        Result result = problem.Solve(8);
        Result result2 = problem2.Solve(8);
        assertEquals(result.totalValue, result2.totalValue);
        assertEquals(result.totalWeight, result2.totalWeight);
    }
}

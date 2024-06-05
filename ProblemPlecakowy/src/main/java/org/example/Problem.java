package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.List;

public class Problem {
    public int n;
    public int seed;
    public int lowerBound;
    public int upperBound;
    public ArrayList<Item> Items;

    public Problem(int N, int Seed, int LowerBound, int UpperBound) {
        n = N;
        seed = Seed;
        lowerBound = LowerBound;
        upperBound = UpperBound;
        Items = GenerateItems(Seed, N);
    }

    ArrayList<Item> GenerateItems(int Seed, int N) {
        Random random = new Random(Seed);
        ArrayList<Item> Items = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            Items.add(new Item(i, random.nextInt(upperBound - lowerBound + 1) + lowerBound, random.nextInt(upperBound - lowerBound + 1) + lowerBound));
        }
        return Items;
    }

    public void AddItemManually(int number, int value, int weight)
    {
        Items.add(new Item(number, value, weight));
    }

    public Result Solve(int capacity) {
        Items.sort(Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());
        ArrayList<Item> Items2 = new ArrayList<>();

        List<Integer> numbers = new ArrayList<>();
        int totalValue = 0;
        int totalWeight = 0;

        for (Item item : Items) {
            while (totalWeight + item.weight <= capacity) {
                numbers.add(item.number);
                totalValue += item.value;
                totalWeight += item.weight;
                Items2.add(new Item(item.number, item.value, item.weight));
            }
        }

        return new Result(numbers, totalValue, totalWeight,Items2);
    }

    public String toString() {
        String result2 = "";
        for (Item item : Items) {
            result2 += "Number: " + item.number + ", Value: " + item.value + ", Weight: " + item.weight + "\n";
        }
        return result2;
    }
}

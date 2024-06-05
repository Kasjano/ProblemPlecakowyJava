package org.example;
import java.util.ArrayList;
import java.util.List;

public class Result {
    public List<Integer> numbers;
    public int totalValue;
    public int totalWeight;
    public ArrayList<Item> Items2;
    public Result(List<Integer> numbers, int totalValue, int totalWeight, ArrayList<Item> Items2) {
        this.numbers = numbers;
        this.totalValue = totalValue;
        this.totalWeight = totalWeight;
        this.Items2 = Items2;
    }

    public String toString() {
        return "Items: " + numbers.toString() + "\n" +
                "Total Value: " + totalValue + "\n" +
                "Total Weight: " + totalWeight;
    }

    public String toString2() {
        String result2 = "";
        for (Item item : Items2) {
            result2 += "Number: " + item.number + ", Value: " + item.value + ", Weight: " + item.weight + "\n";
        }
        return result2;
    }

}

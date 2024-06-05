package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Give number of items:");
        int n = getInt();
        System.out.println("Give seed:");
        int seed = getInt();
        System.out.println("Give knapsack capacity:");
        int capacity = getInt();

        Problem problem = new Problem(n,seed,1,10);
        //problem.AddItemManually(1, 50, 10);
        System.out.println(problem.toString());

        Result result = problem.Solve(capacity);
        System.out.println(result.toString());
        //System.out.println(result.toString2());
    }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }
}
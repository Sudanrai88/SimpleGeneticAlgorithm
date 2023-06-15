package org.example;

public class Genes {
    int [] genePool;

    public Genes() {
        genePool = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    }

    public int[] getGenePool() {
        return genePool;
    }

    public int maxGeneValue() {
        int maxValue = 0;
        for (int x : genePool) {
            if (x > maxValue) {
                maxValue = x;
            }
        }
        return maxValue;
    }
}

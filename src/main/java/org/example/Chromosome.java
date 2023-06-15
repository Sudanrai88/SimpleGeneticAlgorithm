package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Chromosome {
    private ArrayList geneMakeup;
    private int maxChromosome = 8;
    private Genes genes = new Genes();

    public Chromosome() {
        ArrayList chromosome = new ArrayList<>();
        for (int i = 0; i < maxChromosome; i++) {
            int geneValue = chooseGeneValue();
            chromosome.add(geneValue);
        }
        geneMakeup = chromosome;
    }

    public int getMaxChromosome() {
        return maxChromosome;
    }

    public void setMaxChromosome(int maxChromosome) {
        this.maxChromosome = maxChromosome;
    }

    public Genes getGenes() {
        return genes;
    }

    public ArrayList getGeneMakeup() {
        return geneMakeup;
    }

    public void setChromosome(ArrayList chromosome) {
        geneMakeup = chromosome;
    }

    public int chooseGeneValue() {
        Random rand = new Random();
        int upperBound = genes.getGenePool().length;

        return genes.getGenePool()[rand.nextInt(upperBound)];
    }
}

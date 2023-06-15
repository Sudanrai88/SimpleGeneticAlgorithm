package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Population {
    private String populationName;
    Chromosome chromosome;

    public Population(String populationName) {
        this.populationName = populationName;
        chromosome = new Chromosome();
    }

    public String getPopulationName() {
        return populationName;
    }

    public void setPopulationName(String populationName) {
        this.populationName = populationName;
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    public void setChromosome(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

    public int getSum() {
        ArrayList <Integer> chromosomeArray = getChromosome().getGeneMakeup();
        int totalSum = 0;
        for (int value : chromosomeArray) {
            totalSum += value;
        }
        return totalSum;
    }

    public int maxPossibleGenes() {
        //geneMakeup length * max value of genePool
        return  getChromosome().getGeneMakeup().size() * getChromosome().getGenes().maxGeneValue();
    }

    public ArrayList<Integer> getLeftHalfGeneSequence() {
        return new ArrayList<Integer>(getChromosome().getGeneMakeup().subList(0,4));
    }

    public ArrayList<Integer> getRightHalfGeneSequence() {
        return new ArrayList<Integer>(getChromosome().getGeneMakeup().subList(4,8));
    }
}

package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //A simple Genetic algorithm, that chooses the Greatest overall Number. There will be "20 genes" that are initialised randomly from 1 to 20.
        //We shall do a Population of 6, made up of 8 "genetic" information. Population and Chromosome here go hand in hand?
        //We want the algorithm to take the 3 highest SUM of genetic info from the 6 population. We will then do a chromosome crossover between the highest parents and add a mutation which selects randomly from initial "gene" cap (1-20).
        //Run from Evaluate until termination criteria is met ~100 runs or maxSUM of 160 is reached (Goal).

        //Initialization
        int maxPopulation = 6;
        int generationalLoop = 1;
        ArrayList<Population> populations = new ArrayList<>();

        for (int i = 0; i < maxPopulation; i++) {
            populations.add(i, new Population("Population " + (i+1)));
            System.out.println("//Name = " + populations.get(i).getPopulationName() + " //Genetic Makeup = " + populations.get(i).getChromosome().getGeneMakeup() + " //Sum = " + populations.get(i).getSum());
        }
        System.out.println("");
        System.out.println("Start Generations");
        System.out.println("");

        /*getGeneticGod(populations) != populations.get(0).maxPossibleGenes();*/

        while( generationalLoop < 100){ //TERMINATE
            //GenerationalLoop from in this loop
            System.out.println("This is Generation: " + generationalLoop);
            //EVALUATE using getSum()

            //SELECTION top 3 values of getSum from populations[], delete the others
            //sort the populations arrayList using the getSum() from highest to lowest, after delete the bottom 3.

            sortBySum(populations); //Sorted by getSum().
            System.out.println("Generation: " + generationalLoop + " sorted.");

            /*System.out.println(populations.get(5).getPopulationName());*/

            populations.remove(populations.size()-1); //removes the "weakest" 3 populations
            populations.remove(populations.size()-1);
            populations.remove(populations.size()-1);

            System.out.println("Weak from generation " + generationalLoop + ", removed.");

            //VARIATION split the Chromosome in half and take left of populations(0), right of populations(1)
            //create population 4,5,6

            for (int i = 0; i <= 2; i++) { //Creating the offspring
                if(i == 0) {
                    System.out.println("");
                    System.out.println("Added 1'st child for generation: " + generationalLoop + ".");
                    populations.add(((populations.size())), new Population("Population " + (i+ (generationalLoop * 3))));

                    System.out.println("Left of RANK 1:" + populations.get(i).getLeftHalfGeneSequence());
                    System.out.println("Right of RANK 2:" + populations.get(i+1).getRightHalfGeneSequence());
                    //Create a new ArrayList that adds the left-half of STRONGEST and right-half of second STRONGEST of genetics to a new List.
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.addAll(populations.get(i).getLeftHalfGeneSequence());
                    newList.addAll(populations.get(i+1).getRightHalfGeneSequence());

                    populations.get((populations.size() - 1)).getChromosome().setChromosome(newList);
                    mutateChild(populations, populations.size() - 1);
                    System.out.println("Child 1: " + populations.get(populations.size() - 1).getChromosome().getGeneMakeup());
                }
                if (i == 1) {
                    System.out.println("");
                    System.out.println("Added 2'nd child for generation: " + generationalLoop + ".");
                    populations.add(((populations.size())), new Population("Population " + (i+(generationalLoop * 3))));

                    System.out.println("Right of RANK 1:" + populations.get(0).getRightHalfGeneSequence());
                    System.out.println("Left of RANK 2:" + populations.get(i).getLeftHalfGeneSequence());

                    //Create a new ArrayList that adds the right-half of STRONGEST and left-half of second STRONGEST of genetics to a new List.
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.addAll(populations.get(0).getRightHalfGeneSequence());
                    newList.addAll(populations.get(i).getLeftHalfGeneSequence());

                    populations.get((populations.size()) - 1).getChromosome().setChromosome(newList);
                    mutateChild(populations, populations.size() - 1);
                    System.out.println("Child 2: " + populations.get(populations.size() - 1).getChromosome().getGeneMakeup());
                }
                if (i == 2) {
                    System.out.println("");
                    System.out.println("Added 3'rd child for generation: " + generationalLoop + ".");
                    populations.add(((populations.size())), new Population("Population " + (i+(generationalLoop * 3))));
                    populations.get(0).getLeftHalfGeneSequence().addAll(populations.get(i).getRightHalfGeneSequence());

                    System.out.println("Left of RANK 1:" + populations.get(0).getLeftHalfGeneSequence());
                    System.out.println("Right of RANK 3:" + populations.get(i).getRightHalfGeneSequence());

                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.addAll(populations.get(0).getLeftHalfGeneSequence());
                    newList.addAll(populations.get(i).getRightHalfGeneSequence());

                    populations.get((populations.size()) - 1).getChromosome().setChromosome(newList);
                    mutateChild(populations, populations.size() - 1);
                    System.out.println("Child 3: " + populations.get(populations.size() - 1).getChromosome().getGeneMakeup());
                }
            }
            sortBySum(populations);

            /*for (int i = 0; i < populations.size(); i++) {
                System.out.println("//Name = " + populations.get(i).getPopulationName() + " //Genetic Makeup = " + populations.get(i).getChromosome().getGeneMakeup() + " //Sum = " + populations.get(i).getSum());
            }*/


            System.out.print("CHAMPION of generation " + generationalLoop + ": " + populations.get(0).getChromosome().getGeneMakeup());
            System.out.println("    Name: " + populations.get(0).getPopulationName() + "   GeneSum: " + populations.get(0).getSum());
            System.out.println("###########################################################################");
            generationalLoop++;
        }

    }

    public static int getGeneticGod(ArrayList<Population> arr) {
        //from the array of Populations, get the sum of each population and find the maximum
        int highestSum = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if(highestSum <= Math.max(arr.get(i).getSum(), arr.get(i + 1).getSum())) {
                highestSum = Math.max(arr.get(i).getSum(), arr.get(i + 1).getSum());
            }
        }
        return highestSum;
    }

    public static void sortBySum(ArrayList<Population> populations) {
        for (int i = 0; i < populations.size() - 1; i++) {
            for (int j = 0; j < populations.size() - i - 1; j++) {
                if (populations.get(j).getSum() < populations.get(j + 1).getSum()) {
                    Population temp = populations.get(j);
                    populations.set(j, populations.get(j + 1));
                    populations.set(j + 1, temp);
                }
            }
        }
    }

    public static void mutateChild(ArrayList<Population> populations, int index) {
        Genes genes = new Genes();
        //Change a random integer in a new Child's genetics from the genetic pool

        Random rand = new Random();
        int upperBound = 10;

        if (rand.nextInt(upperBound) == 2) {
            Random geneChooser = new Random();
            int upperBound2 = 8;
               //For an ArrayList, select from index 0 - 7. On selected index change that value to a random mutation from genePool.
                ArrayList<Integer> chromosomeMutation =  populations.get(index).getChromosome().getGeneMakeup();
                chromosomeMutation.set(rand.nextInt(upperBound2), rand.nextInt(genes.getGenePool().length + 1));
            System.out.println("Child mutated");
        } else {
            System.out.println("No mutation");
        }
    }



    //Sort the summed mapped values from highest to lowest


}
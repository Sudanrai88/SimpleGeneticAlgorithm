import org.example.Chromosome;
import org.example.Population;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PopulationTest {
    @Test
    public void testGetPopulationName() {
        Population population = new Population("Population 1");

        String result = population.getPopulationName();
        assertEquals("Population 1", result);
    }

    @Test
    public void testSetPopulationName() {
        Population population = new Population("Population 1");

        population.setPopulationName("Population 2");
        String result = population.getPopulationName();

        assertEquals("Population 2", result);
    }

    @Test
    public void testGetChromosome() {
        Population population = new Population("Population 1");
        Chromosome chromosome = new Chromosome();
        population.setChromosome(chromosome);

        Chromosome result = population.getChromosome();
        assertEquals(chromosome, result);
    }

    @Test
    public void testSetChromosome() {
        Population population = new Population("Population 1");
        Chromosome chromosome = new Chromosome();

        population.setChromosome(chromosome);
        Chromosome result = population.getChromosome();

        assertEquals(chromosome, result);
    }

    @Test
    public void testGetSum() {
        Population population = new Population("Population 1");
        population.getChromosome().setChromosome(new ArrayList<>(List.of(4, 4, 3, 13, 9, 11, 11, 14)));

        int result = population.getSum();
        assertEquals(69, result);
    }

    @Test
    public void testMaxPossibleGenes() {
        Population population = new Population("Population 1");
        population.getChromosome().setChromosome(new ArrayList<>(List.of(4, 4, 3, 13, 9, 11, 11, 14)));

        int result = population.maxPossibleGenes();
        assertEquals(160, result);
    }

    // Add more test methods as needed

}


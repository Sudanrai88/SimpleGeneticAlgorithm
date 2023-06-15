import org.example.Main;
import org.example.Population;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void testGetGeneticGod() {
        ArrayList<Population> populations = new ArrayList<>();
        Population population1 = new Population("Population 1");
        population1.getChromosome().setChromosome(new ArrayList<>(List.of(4, 4, 3, 13, 9, 11, 11, 14)));
        populations.add(population1);

        Population population2 = new Population("Population 2");
        population2.getChromosome().setChromosome(new ArrayList<>(List.of(5, 6, 7, 8, 9, 10, 11, 12)));
        populations.add(population2);

        Population population3 = new Population("Population 3");
        population3.getChromosome().setChromosome(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        populations.add(population3);

        int result = Main.getGeneticGod(populations);
        assertEquals(64, result);
    }

    @Test
    public void testSortBySum() {
        ArrayList<Population> populations = new ArrayList<>();
        Population population1 = new Population("Population 1");
        population1.getChromosome().setChromosome(new ArrayList<>(List.of(4, 4, 3, 13, 9, 11, 11, 14)));
        populations.add(population1);

        Population population2 = new Population("Population 2");
        population2.getChromosome().setChromosome(new ArrayList<>(List.of(5, 6, 7, 8, 9, 10, 11, 12)));
        populations.add(population2);

        Population population3 = new Population("Population 3");
        population3.getChromosome().setChromosome(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        populations.add(population3);

        Main.sortBySum(populations);

        assertEquals("Population 1", populations.get(0).getPopulationName());
        assertEquals("Population 2", populations.get(1).getPopulationName());
        assertEquals("Population 3", populations.get(2).getPopulationName());
    }
}

import org.example.Chromosome;
import org.example.Population;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;



public class ChromosomeTest {

    private Chromosome chromosome;

    @BeforeEach
    public void setUp() {
        chromosome = new Chromosome();
    }

    @Test
    public void testSetChromosome() {
        ArrayList<Integer> newChromosome = new ArrayList<>();
        newChromosome.add(1);
        newChromosome.add(2);
        newChromosome.add(3);

        chromosome.setChromosome(newChromosome);

        ArrayList<Integer> geneMakeup = chromosome.getGeneMakeup();
        assertEquals(newChromosome, geneMakeup);
    }


}

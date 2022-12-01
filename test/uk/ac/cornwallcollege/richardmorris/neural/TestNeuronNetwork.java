package uk.ac.cornwallcollege.richardmorris.neural;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNeuronNetwork {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void test_construct_network() {
        NeuronNetwork nn = new NeuronNetwork(2,2);
        var weights = nn.getWeights();
        assertEquals(16+16+4,weights.size());
        assertEquals(16+16+4,nn.numWeights());
    }

    @Test
    public void test_set_weights() {
        NeuronNetwork nn = new NeuronNetwork(2,2);
        int initialCapacity = 16 + 16 + 4;
        List<Double> in_weights = new ArrayList<>(initialCapacity);
        for(int i=0;i<initialCapacity;++i) {
            in_weights.add(1.0+i);
        }
        assertEquals(initialCapacity,in_weights.size());
        nn.setWeights(in_weights);
        var out_weights = nn.getWeights();
        assertEquals(in_weights,out_weights);
    }

}

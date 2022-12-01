package uk.ac.cornwallcollege.richardmorris.neural;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNeuron {

    @Test
    public void test_weighted_sum() {
        PixelNeuron pn1 = new PixelNeuron(1);
        PixelNeuron pn2 = new PixelNeuron(2);
        PixelNeuron pn3 = new PixelNeuron(3);
        PixelNeuron pn4 = new PixelNeuron(4);

        pn1.setPixelValue(1.0);
        pn2.setPixelValue(2.0);
        pn3.setPixelValue(3.0);
        pn4.setPixelValue(4.0);

        Neuron output = new Neuron(5);
        output.add(pn1);
        output.add(pn2);
        output.add(pn3);
        output.add(pn4);

        List<Double> weights = Arrays.asList(1.0,2.0,3.0,4.0);
        output.setWeights(weights);
        double res = output.getWeightedSum();
        assertEquals(1.0+4+9+16,res,0);
    }
}

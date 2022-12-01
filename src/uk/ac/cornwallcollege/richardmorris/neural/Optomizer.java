package uk.ac.cornwallcollege.richardmorris.neural;

import java.util.ArrayList;
import java.util.List;

public class Optomizer {
    NeuronNetwork nn;
    int num_candidates;
    List<List<Double>> candidates;
    List<List<Double>> output_values;
    List<InputAndTarget> test_data;

    public Optomizer(NeuronNetwork nn, int num_candidates, int num_images) {
        this.nn = nn;
        int num_weights = nn.numWeights();
        this.num_candidates = num_candidates;
        candidates = new ArrayList<>(num_candidates);
        for(int i=0;i<num_candidates;++i) {
            List<Double> weights = new ArrayList<>(num_weights);
            for(int j=0;j<num_weights;++j) {
                weights.add( Math.random() * 2 - 1); // range -1 to + 1
            }
            candidates.add(weights);
        }
        output_values = new ArrayList<>(num_candidates);

    }

    public void setInputOutput(List<Double> pixels, double target) {
        test_data.add(new InputAndTarget(pixels,target));
    }

    public List<Double> runTestsOn(List<Double> candidate) {
        List<Double> results = new ArrayList<>(test_data.size());

        nn.setWeights(candidate);
        for(var test: test_data) {
            nn.setPixels(test.input());
            results.add(nn.getOutputValue());
        }
        return results;
    }

    public double calcFitness(List<Double> testResults) {
        double dot_product = 0.0;
        var it1 = test_data.iterator();
        var it2 = testResults.iterator();
        while(it1.hasNext() && it2.hasNext()) {
            var test = it1.next();
            var result = it2.next();
            dot_product += test.target() * result;
        }
        return dot_product;
    }

    public List<Double> findBestFit() {
        double bestFitValue = Double.NEGATIVE_INFINITY;
        List<Double> bestFitWeights = null;

        for(var candidate : candidates) {
            var results = runTestsOn(candidate);
            double fitness = calcFitness(results);
            if(fitness > bestFitValue) {
                bestFitWeights = candidate;
                bestFitValue = fitness;
            }
        }
        return bestFitWeights;
    }
}

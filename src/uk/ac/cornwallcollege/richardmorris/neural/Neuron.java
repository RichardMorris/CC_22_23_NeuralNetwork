package uk.ac.cornwallcollege.richardmorris.neural;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private int num;

    // Sets up a list to hold the number of outputs
    List<Neuron> outputs = new ArrayList<>();
    List<Double> weights = new ArrayList<>();
    // Constructor - sets the class to be in a
    // consistent starting state
    // Same name as the class, no return value
    public Neuron(int n) {
        num = n;
    }

    /**
     *     Add an item to the list of outputs,
     *     also add a weight with default value 1
      */
    public boolean add(Neuron neuron) {
        boolean b1 = outputs.add(neuron);
        boolean b2 = weights.add(1.0);
        return b1 && b2;
    }
    public void fire() {
        System.out.println("fire "+ this);
        for(var n : outputs) {
            n.fire();
        }
    }

    /**
     * Find the weighted sum of all the input values.
     * @return
     */
    public double getWeightedSum() {
        double result = 0.0;
        for(int i=0;i<outputs.size();++i) {
            var ele = outputs.get(i);
            double weight = weights.get(i);
            result += ele.getWeightedSum() * weight;
        }
        return result;
    }
    public int getNum() {
        return num;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> in_weights) {
        if(in_weights.size() != weights.size())
            throw new IllegalStateException("Miss match in size of weights");
        this.weights = in_weights;
    }

    @Override
    public String toString() {
        return "Neuron{" + num + "}";
    }

    public int getNumWeights() {
        return weights.size();
    }
}

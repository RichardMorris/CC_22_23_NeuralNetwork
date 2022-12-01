package uk.ac.cornwallcollege.richardmorris.neural;

import java.util.List;

public record Results(List<Double> weights, double fitness, List<Double> results) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fitness\t");
        sb.append(fitness);

        sb.append("\nresults\t[");
        for(var val:results) {
            sb.append(String.format("%6.3f ",val));
        }

        sb.append("]\nweights\t[");
        for(var val:weights) {
            sb.append(String.format("%6.3f ",val));
        }
        return sb.toString();
    }
}

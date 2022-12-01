package uk.ac.cornwallcollege.richardmorris.neural;

import java.util.ArrayList;
import java.util.List;

public class NeuronNetwork {
    int width;
    int height;
    int layers;

    List<PixelNeuron> pixels = new ArrayList<>(width*height);
    List<Neuron> layer1 = new ArrayList<>(width*height);
    List<Neuron> layer2 = new ArrayList<>(width*height);

    Neuron outputNeuron;

    public NeuronNetwork(int width, int height) {
        this.width = width;
        this.height = height;
        this.layers = 2;
        int count=0;
        for(int i=0; i<width;++i) {
            for(int j=0; j<height; ++j) {
                pixels.add(new PixelNeuron(count++));
            }
        }
        for(int i=0; i<width;++i) {
            for(int j=0; j<height; ++j) {
                layer1.add(new Neuron(count++));
            }
        }
        for(int i=0; i<width;++i) {
            for(int j=0; j<height; ++j) {
                layer2.add(new Neuron(count++));
            }
        }
        outputNeuron = new Neuron((count++));

        for(var l1 : layer1) {
            for(var pn : pixels) {
                l1.add(pn);
            }
        }
        for(var l2 : layer2) {
            for(var l1 : layer1) {
                l2.add(l1);
            }
        }
        for(var l2 : layer2) {
            outputNeuron.add(l2);
        }
    }

    List<Double> getWeights() {
        List<Double> result = new ArrayList<>();
        for (var l1 : layer1) {
            result.addAll(l1.getWeights());
        }
        for (var l1 : layer2) {
            result.addAll(l1.getWeights());
        }
        result.addAll(outputNeuron.getWeights());

        return result;
    }

    public int numWeights() {
        int res = 0;
        for (var l1 : layer1) {
            res += l1.getNumWeights();
        }
        for (var l1 : layer2) {
            res += l1.getNumWeights();
        }
        res += outputNeuron.getNumWeights();
        return res;
    }
    void setWeights(List<Double> newWeights) {
        int pos = 0;
        for (var l1 : layer1) {
            l1.setWeights(newWeights.subList(pos, pos + l1.getNumWeights()));
            pos += l1.getNumWeights();
        }
        for (var l2 : layer2) {
            l2.setWeights(newWeights.subList(pos, pos + l2.getNumWeights()));
            pos += l2.getNumWeights();
        }
        {
            outputNeuron.setWeights(newWeights.subList(pos, pos + outputNeuron.getNumWeights()));
            pos += outputNeuron.getNumWeights();
        }
    }

    void setPixels(List<Double> vals) {
        for(int i=0;i<pixels.size();++i) {
            pixels.get(i).setPixelValue(vals.get(i));
        }
    }

    double getOutputValue() {
        return outputNeuron.getWeightedSum();
    }
}

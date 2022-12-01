package uk.ac.cornwallcollege.richardmorris.neural;

public class PixelNeuron extends Neuron {
    double pixel_value;

    public PixelNeuron(int n) {
        super(n);
    }

    public void setPixelValue(double pixel) {
        pixel_value = pixel;
    }

    @Override
    public double getWeightedSum() {
        return pixel_value;
    }
}

package uk.ac.cornwallcollege.richardmorris.neural;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var nn = new NeuronNetwork(2,2);
        var opt = new Optomizer(nn,10,16);
        opt.setInputOutput(Arrays.asList(0.0,0.0,0.0,0.0), -0.1);
        opt.setInputOutput(Arrays.asList(0.0,0.0,0.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(0.0,0.0,1.0,0.0), -0.1);
        opt.setInputOutput(Arrays.asList(0.0,0.0,1.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(0.0,1.0,0.0,0.0), -0.1);
        opt.setInputOutput(Arrays.asList(0.0,1.0,0.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(0.0,1.0,1.0,0.0), 1.0);
        opt.setInputOutput(Arrays.asList(0.0,1.0,1.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,0.0,0.0,0.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,0.0,0.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,0.0,1.0,0.0), 1.0);
        opt.setInputOutput(Arrays.asList(1.0,0.0,1.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,1.0,0.0,0.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,1.0,0.0,1.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,1.0,1.0,0.0), -0.1);
        opt.setInputOutput(Arrays.asList(1.0,1.0,1.0,1.0), -0.1);


        opt.printTargets();

        double factor = 2.0;
        for(int i=0; i< 10;++i) {
            var res = opt.findBestFit();
            System.out.println(res);

            factor *= 0.5;
            opt.generateNextRound(res.weights(), factor);
        }

    }
}
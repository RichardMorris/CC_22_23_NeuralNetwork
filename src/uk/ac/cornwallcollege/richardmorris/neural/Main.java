package uk.ac.cornwallcollege.richardmorris.neural;

public class Main {
    public static void main(String[] args) {
        Neuron n0 = new Neuron(0);
        System.out.println(n0.toString());
        Neuron n1 = new Neuron(1);
        System.out.println(n1.toString());
        Neuron n2 = new Neuron(2);
        System.out.println(n2.toString());
        Neuron n3 = new Neuron(3);
        System.out.println(n3.toString());
        Neuron n4 = new Neuron(4);
        System.out.println(n4.toString());

        n1.add(n3);
        n1.add(n4);

        n2.add(n4);

        n3.add(n0);
        n4.add(n0);
        n1.fire();
    }
}
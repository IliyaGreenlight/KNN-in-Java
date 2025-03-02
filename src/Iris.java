public class Iris {
    private double[] parameters;
    private String type;

    public Iris(double[] parameters, String type) {
        this.parameters = parameters;
        this.type = type;
    }

    public double[] getParameters() {
        return parameters;
    }

    public String getType() {
        return type;
    }
}

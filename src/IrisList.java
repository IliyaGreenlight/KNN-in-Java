import java.util.ArrayList;

public class IrisList {
    private ArrayList<Iris> irises;

    public IrisList() {
        this.irises = new ArrayList<>();
    }

    public void addiris(double[] parameters, String type){
        irises.add(new Iris(parameters, type));
    }

    public Iris getIris(int index){
        return irises.get(index);
    }
    public int size(){return irises.size();}
}

public class Pair implements Comparable<Pair>{
    private double number;
    private String type;

    public Pair(double number, String type) {
        this.number = number;
        this.type = type;
    }

    public double getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public void increment(){
        number +=1;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "number=" + number +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pair p) {
        return Double.compare(getNumber(), p.getNumber());
    }
}

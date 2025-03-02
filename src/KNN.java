import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public abstract class KNN {
    private static int K = 1;
    private static final IrisList irises = new IrisList();

    public static void setK(int k){
        K = k;
    }

    public static void train(ArrayList<String> input){
        for (String s : input) {
            TreeMap<String, double[]> irisData = Parser.parse(s);
            irises.addiris(irisData.get(irisData.firstKey()), irisData.firstKey());
        }
    }

    public static boolean clusterize(String testData){
        Pair[] distances = new Pair[irises.size()];
        TreeMap<String, double[]> testIris = Parser.parse(testData);
        for (int i = 0; i < irises.size(); i++) {
            distances[i] = new Pair(distance(irises.getIris(i).getParameters(), testIris.get(testIris.firstKey())), irises.getIris(i).getType());
        }
        Arrays.sort(distances);
        ArrayList<Pair> counter = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            index(counter, distances[i]);
        }
        Collections.sort(counter);
        System.out.println("Given: " + testIris.firstKey()  + " |Calculated: " + counter.get(counter.size()-1).getType());
        return counter.get(counter.size()-1).getType().equals(testIris.firstKey());
    }

    private static double distance(double[] p1, double[] p2){
        double d = 0;
        for (int i = 0; i < p1.length; i++) {
            d += Math.pow(p1[i]-p2[i], 2);
        }
        //d = Math.sqrt(d);
        return d;
    }

    private static void index(ArrayList<Pair> counter, Pair distance){
        for (Pair pair : counter) {
            if (pair.getType().equals(distance.getType())) {
                pair.increment();
                return;
            }
        }
        counter.add(new Pair(1, distance.getType()));
    }
}

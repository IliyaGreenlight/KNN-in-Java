import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Provide the path to the training file: ");
        //String path = sc.next();
        String path = "C:\\Users\\ilyag\\Downloads\\train.txt";
        KNN.train(new ArrayList<>(DataReader.readDataset(path)));

        System.out.println("Input K - number of nearest neighbours: ");
        int k = sc.nextInt();
        KNN.setK(k);

        int options;
        while (true) {
            System.out.println("Choose an option:\n 1. Test the file\n 2. Test the given iris\n 3. Change K\n 4. Exit");
            options = sc.nextInt();
            switch (options) {
                case 1:
                    //System.out.println("Provide the path to the testing file: ");
                    //path = sc.next();
                    path = "C:\\Users\\ilyag\\Downloads\\test.txt";
                    ArrayList<String> test = new ArrayList<>(DataReader.readDataset(path));
                    int succes = 0;
                    for (String s : test) {
                        if(KNN.clusterize(s)){
                            succes++;
                        }
                    }
                    System.out.println("Success rate is " + ((succes * 1.)/test.size())*100 + "%");
                    break;
                case 2:
                    System.out.println("Enter an iris you'd like to test: ");
                    String s = sc.next();
                    KNN.clusterize(s);
                    break;
                case 3:
                    System.out.println("Enter new K: ");
                    k = sc.nextInt();
                    KNN.setK(k);
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
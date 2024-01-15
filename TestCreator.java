import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TestCreator {
    public static void createTest(Integer testNumber) throws IOException {
        StringBuilder output = new StringBuilder();

        //creating a list of node values and shuffling it
        Random randomNumberOfNodes = new Random();
        Integer numberOfNodes = randomNumberOfNodes.nextInt(5000,10000);
        ArrayList<Integer> list = new ArrayList<>();
        for (int index = 0; index < numberOfNodes; index++) {
            list.add(index);
        }

        Collections.shuffle(list);
        //list created and shuffled

        //creating the tree and the edge list
        BinarySearchTree tree = new BinarySearchTree();
        for (Integer i : list) {
            tree.insert(i);
        }

        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
        tree.edgelist(tree.root, edgeList);
        //tree and edge list created

        //creating a random number of interrogations
        Random randomInterrogations = new Random();
        Integer numberInterrogations = randomInterrogations.nextInt(5000, 10000);

        //writing the test to file
        output.append(numberOfNodes + "\n" + numberInterrogations + "\n");

        for (ArrayList<Integer> integer : edgeList) {
            output.append(integer.get(0) + " " + integer.get(1) + "\n");
        }

        for (int i = 0; i < numberInterrogations; i++) {
            Integer first = randomInterrogations.nextInt(numberOfNodes);
            Integer second = randomInterrogations.nextInt(numberOfNodes);
            output.append(first + " " + second + "\n");
        }
        output.deleteCharAt(output.length() - 1);

        File dir = new File("in");
        dir.mkdir();
        File testFile = new File("in/test" + testNumber.toString() + ".in");
        testFile.createNewFile();

        FileWriter writer = new FileWriter(testFile);
        writer.write(output.toString());
        writer.close();
        //done writing
    }
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 30; i++) {
            createTest(i);
        }
    }
}

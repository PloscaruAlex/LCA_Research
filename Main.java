import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void executeTestFirstAlgorithm(Integer testNumber) throws IOException {
        BinarySearchTree tree = new BinarySearchTree();

        File outputFile = new File("RESULTS/1test" + testNumber.toString() + ".txt");
        outputFile.createNewFile();
        FileWriter writer = new FileWriter(outputFile);
        File timeFile = new File("TIME_INTERROGATIONS/1test" + testNumber.toString() + ".txt");
        timeFile.createNewFile();
        FileWriter timeWriter = new FileWriter(timeFile);
        File archiveFile = new File("out/test" + testNumber.toString() + ".out");
        archiveFile.createNewFile();
        FileWriter writerArchive = new FileWriter(archiveFile);

        File inputFile = new File("in/test" + testNumber.toString() + ".in");
        Scanner scanner = new Scanner(inputFile);

        Integer numberOfNodes = Integer.parseInt(scanner.nextLine());
        Integer numberOfInterrogations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNodes - 1; i++) {
            String edge = scanner.nextLine();
            String[] values = edge.split(" ");
            Integer first = Integer.parseInt(values[0]);
            Integer second = Integer.parseInt(values[1]);
            tree.addEdge(first, second);
        }

        for (int i = 0; i < numberOfInterrogations; i++) {
            String interrogation = scanner.nextLine();
            String[] values = interrogation.split(" ");
            Integer first = Integer.parseInt(values[0]);
            Integer second = Integer.parseInt(values[1]);

            long start = System.nanoTime();
            Integer result = FirstAlgorithm.findLCA(tree.root, first, second);
            long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds

            writer.write(result + "\n");
            writerArchive.write(result + "\n");
            timeWriter.write(timeElapsed + "\n");
        }
        writer.close();
        timeWriter.close();
        writerArchive.close();
    }

    public static void executeTestSecondAlgorithm(Integer testNumber) throws IOException {
        BSTWithParent tree = new BSTWithParent();

        File outputFile = new File("RESULTS/2test" + testNumber.toString() + ".txt");
        outputFile.createNewFile();
        FileWriter writer = new FileWriter(outputFile);
        File timeFile = new File("TIME_INTERROGATIONS/2test" + testNumber.toString() + ".txt");
        timeFile.createNewFile();
        FileWriter timeWriter = new FileWriter(timeFile);
        File archiveFile = new File("out/test" + testNumber.toString() + ".out");
        archiveFile.createNewFile();
        FileWriter writerArchive = new FileWriter(archiveFile);

        File inputFile = new File("in/test" + testNumber.toString() + ".in");
        Scanner scanner = new Scanner(inputFile);

        Integer numberOfNodes = Integer.parseInt(scanner.nextLine());
        Integer numberOfInterrogations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNodes - 1; i++) {
            String edge = scanner.nextLine();
            String[] values = edge.split(" ");
            Integer first = Integer.parseInt(values[0]);
            Integer second = Integer.parseInt(values[1]);
            tree.addEdge(first, second);
        }

        for (int i = 0; i < numberOfInterrogations; i++) {
            String interrogation = scanner.nextLine();
            String[] values = interrogation.split(" ");
            Integer first = Integer.parseInt(values[0]);
            Integer second = Integer.parseInt(values[1]);

            long start = System.nanoTime();
            Integer result = SecondAlgorithm.findLCA(tree.root, first, second);
            long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds

            writer.write(result + "\n");
            writerArchive.write(result + "\n");
            timeWriter.write(timeElapsed + "\n");
        }
        writer.close();
        timeWriter.close();
        writerArchive.close();
    }

    public static void executeTestThirdAlgorithm(Integer testNumber) throws IOException {
        BinarySearchTree tree = new BinarySearchTree();

        File outputFile = new File("RESULTS/3test" + testNumber.toString() + ".txt");
        outputFile.createNewFile();
        FileWriter writer = new FileWriter(outputFile);
        File timeFile = new File("TIME_INTERROGATIONS/3test" + testNumber.toString() + ".txt");
        timeFile.createNewFile();
        FileWriter timeWriter = new FileWriter(timeFile);
        File archiveFile = new File("out/test" + testNumber.toString() + ".out");
        archiveFile.createNewFile();
        FileWriter writerArchive = new FileWriter(archiveFile);

        File inputFile = new File("in/test" + testNumber.toString() + ".in");
        Scanner scanner = new Scanner(inputFile);

        Integer numberOfNodes = Integer.parseInt(scanner.nextLine());
        Integer numberOfInterrogations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNodes - 1; i++) {
            String edge = scanner.nextLine();
            String[] values = edge.split(" ");
            Integer first = Integer.parseInt(values[0]);
            Integer second = Integer.parseInt(values[1]);
            tree.addEdge(first, second);
        }

        ThirdAlgorithm thirdAlgorithm = new ThirdAlgorithm(numberOfNodes, tree);

        for (int i = 0; i < numberOfInterrogations; i++) {
            String interrogation = scanner.nextLine();
            String[] values = interrogation.split(" ");
            Integer first = Integer.parseInt(values[0]);
            Integer second = Integer.parseInt(values[1]);

            long start = System.nanoTime();
            Integer result = ThirdAlgorithm.findLCA(tree.root, first, second);
            long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds

            writer.write(result + "\n");
            writerArchive.write(result + "\n");
            timeWriter.write(timeElapsed + "\n");
        }
        writer.close();
        timeWriter.close();
        writerArchive.close();
    }

    public static void main(String[] args) throws IOException {
        File dir1 = new File("TIME_PROGRAMS");
        dir1.mkdir();
        File dir2 = new File("TIME_INTERROGATIONS");
        dir2.mkdir();
        File dir3 = new File("RESULTS");
        dir3.mkdir();
        File dir4 = new File("MEMORY_PROGRAMS");
        dir4.mkdir();
        File dir5 = new File("out");
        dir5.mkdir();

        if (args.length == 0) {
            File timeFile1 = new File("TIME_PROGRAMS/1time.txt");
            timeFile1.createNewFile();
            FileWriter timeWriter1 = new FileWriter(timeFile1);
            File memoryFile1 = new File("MEMORY_PROGRAMS/1memory.txt");
            memoryFile1.createNewFile();
            FileWriter memoryWriter1 = new FileWriter(memoryFile1);
            for (int i = 1; i <= 30; i++) {
                long start = System.nanoTime();
                executeTestFirstAlgorithm(i);
                long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds
                timeWriter1.write(timeElapsed + "\n");
                memoryWriter1.write((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB\n");
            }
            timeWriter1.close();
            memoryWriter1.close();

            File timeFile2 = new File("TIME_PROGRAMS/2time.txt");
            timeFile2.createNewFile();
            FileWriter timeWriter2 = new FileWriter(timeFile2);
            File memoryFile2 = new File("MEMORY_PROGRAMS/2memory.txt");
            memoryFile2.createNewFile();
            FileWriter memoryWriter2 = new FileWriter(memoryFile2);
            for (int i = 1; i <= 30; i++) {
                long start = System.nanoTime();
                executeTestSecondAlgorithm(i);
                long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds
                timeWriter2.write(timeElapsed + "\n");
                memoryWriter2.write((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB\n");
            }
            timeWriter2.close();
            memoryWriter2.close();

            File timeFile3 = new File("TIME_PROGRAMS/3time.txt");
            timeFile3.createNewFile();
            FileWriter timeWriter3 = new FileWriter(timeFile3);
            File memoryFile3 = new File("MEMORY_PROGRAMS/3memory.txt");
            memoryFile3.createNewFile();
            FileWriter memoryWriter3 = new FileWriter(memoryFile3);
            for (int i = 1; i <= 30; i++) {
                long start = System.nanoTime();
                executeTestThirdAlgorithm(i);
                long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds
                timeWriter3.write(timeElapsed + "\n");
                memoryWriter3.write((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB\n");
            }
            timeWriter3.close();
            memoryWriter3.close();
            return;
        }

        if (args[0].equals("p1")) {
            File timeFile1 = new File("TIME_PROGRAMS/1time.txt");
            timeFile1.createNewFile();
            FileWriter timeWriter1 = new FileWriter(timeFile1);
            File memoryFile1 = new File("MEMORY_PROGRAMS/1memory.txt");
            memoryFile1.createNewFile();
            FileWriter memoryWriter1 = new FileWriter(memoryFile1);
            for (int i = 1; i <= 30; i++) {
                long start = System.nanoTime();
                executeTestFirstAlgorithm(i);
                long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds
                timeWriter1.write(timeElapsed + "\n");
                memoryWriter1.write((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB\n");
            }
            timeWriter1.close();
            memoryWriter1.close();
            return;
        } else if (args[0].equals("p2")) {
            File timeFile2 = new File("TIME_PROGRAMS/2time.txt");
            timeFile2.createNewFile();
            FileWriter timeWriter2 = new FileWriter(timeFile2);
            File memoryFile2 = new File("MEMORY_PROGRAMS/2memory.txt");
            memoryFile2.createNewFile();
            FileWriter memoryWriter2 = new FileWriter(memoryFile2);
            for (int i = 1; i <= 30; i++) {
                long start = System.nanoTime();
                executeTestSecondAlgorithm(i);
                long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds
                timeWriter2.write(timeElapsed + "\n");
                memoryWriter2.write((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB\n");
            }
            timeWriter2.close();
            memoryWriter2.close();
            return;
        } else if (args[0].equals("p3")) {
            File timeFile3 = new File("TIME_PROGRAMS/3time.txt");
            timeFile3.createNewFile();
            FileWriter timeWriter3 = new FileWriter(timeFile3);
            File memoryFile3 = new File("MEMORY_PROGRAMS/3memory.txt");
            memoryFile3.createNewFile();
            FileWriter memoryWriter3 = new FileWriter(memoryFile3);
            for (int i = 1; i <= 30; i++) {
                long start = System.nanoTime();
                executeTestThirdAlgorithm(i);
                long timeElapsed = (System.nanoTime() - start) / 1000; //microseconds
                timeWriter3.write(timeElapsed + "\n");
                memoryWriter3.write((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB\n");
            }
            timeWriter3.close();
            memoryWriter3.close();
            return;
        }
    }
}
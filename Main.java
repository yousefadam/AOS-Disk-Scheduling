import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static String path;
    static String input;
    static int initialHeadStart;
    static int diskSize;
    static int direction;
    static ArrayList<Integer> initialSequence = new ArrayList<Integer>();

    public static void main(String[] args) {
        ParseInput();
        RunAlgorithms();
    }

    public static void ParseInput(){

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Insert the absolute path of the file containing the initial sequence.");
        //path = scanner.nextLine();
        path = "InitialSequence.txt";
        try {
            Scanner fileReader = new Scanner(new File(path));
            input = fileReader.nextLine();
            String[] arr = input.split(", ");
            for (String element: arr) {
                initialSequence.add(Integer.parseInt(element));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Insert the initial head start.");
        initialHeadStart = scanner.nextInt();

        System.out.println("Insert the disk size.");
        diskSize = scanner.nextInt();

        System.out.println("Insert the direction (1 means from left to right, 0 means from right to left).");
        direction = scanner.nextInt();
        //DiskScheduler scheduler = new DiskScheduler(initialSequence, initialHeadStart, diskSize);
    }

    public static void RunAlgorithms(){

        DiskScheduler FCFS = new FCFS(initialSequence, initialHeadStart);
        FCFS.run();

        DiskScheduler SSTF = new SSTF(initialSequence, initialHeadStart);
        SSTF.run();

        DiskScheduler Scan = new Scan(initialSequence, initialHeadStart, diskSize, direction);
        Scan.run();

        DiskScheduler cScan = new CircularScan(initialSequence, initialHeadStart, diskSize, direction);
        cScan.run();

        DiskScheduler Look = new Look(initialSequence, initialHeadStart, direction);
        Look.run();

        DiskScheduler cLook = new CircularLook(initialSequence, initialHeadStart, direction);
        cLook.run();

        DiskScheduler optimized = new Optimized(initialSequence, initialHeadStart);
        optimized.run();
    }
}


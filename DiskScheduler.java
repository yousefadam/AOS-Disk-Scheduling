import java.util.ArrayList;

public abstract class DiskScheduler {
    int totalHeadMovements;
    int initialHeadStart;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    ArrayList<Integer> initialSequence = new ArrayList<Integer>();

    DiskScheduler(ArrayList<Integer> initialSequence, int initialHeadStart){
        totalHeadMovements = 0;
        this.initialSequence = initialSequence;
        this.initialHeadStart = initialHeadStart;
    }

    public abstract void run();
    public void printResults(String algName, int THM, ArrayList<Integer> sequence)
    {
        System.out.println(algName +": ");
        System.out.print("Sequence");
        for (Integer element:sequence) {
            System.out.print(" -> " + element);
        }
        System.out.println("\nTotal Head Movements: " + THM);

        GUI gui = new GUI(sequence, algName);
        gui.setSize(600,600);
        gui.setResizable(false);
        gui.setVisible(true);
    }
}

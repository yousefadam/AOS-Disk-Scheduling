import java.util.ArrayList;
import java.util.Collections;

public class Optimized extends DiskScheduler{
    int diskSize;
    int totalHeadMovements;
    ArrayList<Integer> initialSequenceTemp = new ArrayList<Integer>();

    Optimized(ArrayList<Integer> initialSequence, int initialHeadStart) {
        super(initialSequence, initialHeadStart);
        initialSequenceTemp.addAll(initialSequence);
        totalHeadMovements = 0;
    }

    @Override
    public void run() {
        int initialIndex = 0;
        int currentHead = 0;
        int current = 0;

        initialSequenceTemp.add(0, 0);
        Collections.sort(initialSequenceTemp);

        for(int i = 0; i<initialSequenceTemp.size(); i++){
            sequence.add(initialSequenceTemp.get(i));
            current = initialSequenceTemp.get(i);
            totalHeadMovements += Math.abs(currentHead - current);
            currentHead = current;
        }


    }

    @Override
    public void printResults() {
        System.out.println("Optimized :");
        System.out.print("Sequence");
        for (Integer element:sequence) {
            System.out.print(" -> " + element);
        }
        System.out.println("\nTotal Head Movements: " + totalHeadMovements);
    }
}

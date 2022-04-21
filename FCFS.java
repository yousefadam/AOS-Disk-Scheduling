import java.util.ArrayList;

public class FCFS extends DiskScheduler{
    ArrayList<Integer> initialSequenceTemp = new ArrayList<Integer>();

    FCFS(ArrayList<Integer> initialSequence, int initialHeadStart) {
        super(initialSequence, initialHeadStart);
        initialSequenceTemp.addAll(initialSequence);

    }

    @Override
    public void run() {
        for(int i = 0; i < initialSequenceTemp.size(); i++){
            if(i != 0){
                totalHeadMovements += Math.abs(initialSequenceTemp.get(i) - initialSequenceTemp.get(i - 1));
            }
            else {
                totalHeadMovements += Math.abs(initialHeadStart - initialSequenceTemp.get(i));
                sequence.add(initialHeadStart);
            }
            sequence.add(initialSequenceTemp.get(i));
        }
    }

    @Override
    public void printResults() {
        System.out.println("FCFS:");
        System.out.print("Sequence");
        for (Integer element:sequence) {
            System.out.print(" -> " + element);
        }
        System.out.println("\nTotal Head Movements: " + totalHeadMovements);
    }
}

import java.util.ArrayList;
import java.util.Collections;

public class CircularScan extends DiskScheduler{
    ArrayList<Integer> initialSequenceTemp = new ArrayList<Integer>();

    int diskSize;
    int direction;

    CircularScan(ArrayList<Integer> initialSequence, int initialHeadStart, int diskSize, int direction) {
        super(initialSequence, initialHeadStart);
        this.diskSize = diskSize - 1;
        this.direction = direction;
        initialSequenceTemp.addAll(initialSequence);
        totalHeadMovements = 0;
    }

    @Override
    public void run() {
        int initialIndex = 0;
        int currentHead = 0;
        int current = 0;
        initialSequenceTemp.add(initialHeadStart);

        sequence.add(initialHeadStart);

        initialSequenceTemp.add(diskSize);
        initialSequenceTemp.add(0, 0);

        Collections.sort(initialSequenceTemp);
        for(int i = 0; i < initialSequenceTemp.size(); i++){
            if(initialSequenceTemp.get(i).equals(initialHeadStart)){
                initialIndex = i;
                break;
            }
        }



        if(direction == 1){ //From left to right
            currentHead = initialHeadStart;
            for(int i = initialIndex + 1 ; i < initialSequenceTemp.size(); i++){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }

            for(int i = 0; i < initialIndex; i++){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }
        }
        else{ //From right to left

            currentHead = initialHeadStart;
            for(int i = initialIndex - 1; i >= 0; i--){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }
            for(int i = initialSequenceTemp.size() - 1 ; i > initialIndex + 1; i--){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }
        }
        printResults("CircularScan", totalHeadMovements, sequence);
    }


}

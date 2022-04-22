import java.util.ArrayList;
import java.util.Collections;

public class Scan extends DiskScheduler{
    ArrayList<Integer> initialSequenceTemp = new ArrayList<Integer>();

    int diskSize;
    int direction;
    Scan(ArrayList<Integer> initialSequence, int initialHeadStart, int diskSize, int direction) {
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
        Collections.sort(initialSequenceTemp);
        for(int i = 0; i < initialSequenceTemp.size(); i++){
            if(initialSequenceTemp.get(i).equals(initialHeadStart)){
                initialIndex = i;
                break;
            }
        }

        if(direction == 1){ //From left to right
            initialSequenceTemp.add(diskSize);
            currentHead = initialHeadStart;
            for(int i = initialIndex + 1 ; i < initialSequenceTemp.size(); i++){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }

            for(int i = initialIndex - 1; i >= 0; i--){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }
        }
        else{ //From right to left
            initialIndex++;
            initialSequenceTemp.add(0, 0);
            currentHead = initialHeadStart;
            for(int i = initialIndex - 1; i >= 0; i--){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }
            for(int i = initialIndex + 1; i < initialSequenceTemp.size(); i++){
                sequence.add(initialSequenceTemp.get(i));
                current = initialSequenceTemp.get(i);
                totalHeadMovements += Math.abs(currentHead - current);
                currentHead = current;
            }
        }

        printResults("Scan", totalHeadMovements, sequence);
    }


}

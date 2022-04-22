import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends JFrame{
    ArrayList<Integer> points;

    public void paint(Graphics g) { // draw the nodes and edges
        g.clearRect(0, 80, getWidth(), getHeight());
        drawGraph();
    }

    public void drawGraph() {


        //draws the horizontal line for the scale above
        this.getGraphics().drawLine(0, 100, 500, 100);
        int y = 150;
        int i,x = 15;
        int scale = 2;
        for (i = 0; i < points.size() - 1; ++i){

            //draw points
            this.getGraphics().fillOval(scale*(10+points.get(i))-5, y - 5, 10, 10);

            //draw lines connecting the points
            this.getGraphics().drawLine((int)scale*(10 + points.get(i)), y, (int)scale*(10 + points.get(i + 1)), y += 35);
        }
        y=150;
        Collections.sort(points);
        for (var point : points) {
            int lg =(int) Math.log10(point);
            this.getGraphics().drawLine(scale*(10 + point), 90, scale*(10 + point), 100);
            this.getGraphics().drawString(Integer.toString(point),scale*(10 + point)-lg*5,100+x);
            x*=-1;
            y+=35;
        }



    }

    public GUI(ArrayList<Integer> points, String title) {
        super(title);
        super.setBackground(Color.WHITE);
        this.points = points;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}

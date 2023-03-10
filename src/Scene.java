import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Scene extends JFrame {
    private int width;
    private int height;
    private Group group;


    public Scene(String[] size){
        width = Integer.parseInt(size[0]) * 50;
        height = Integer.parseInt(size[1]) * 50 + 50;
        config();

    }
    private void config(){
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }
    public void setGroup(Group group){
        this.group = group;

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(int w = 0; w < width; w += 50){
            g.drawLine(w, 50, w, height);
        }
        for(int h = 0; h < height + 51; h += 50){
            g.drawLine(0, h, width, h);
        }
        for(int cell = 0; cell < group.size(); cell++){
            g.setColor(group.get(cell).getColor());
            g.fillRect(group.get(cell).getX(), group.get(cell).getY(), 50, 50);
        }
    }

}

import java.awt.*;

public class Cell {
    private int x;
    private int y;
    private Color color;
    public  Cell(int x, int y, String[] xyStart, Color color){
        this.x = (x + Integer.parseInt(xyStart[0]) - 1) * 50;
        this.y = (y + Integer.parseInt(xyStart[1]) - 1) * 50 + 50;
        this.color = color;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Color getColor(){
        return color;
    }
}

import java.awt.*;

public class Cell {
    private int x;
    private int y;
    private Color color;
    public  Cell(int x, int y, Color color){
        this.x = x * 50;
        this.y = y * 50 + 50;
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

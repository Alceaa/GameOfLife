import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static char[][] cage;
    private static String field_size_input;
    private static String[] field_size;
    private static String path = "1";
    private static int time;
    private static String xyStart_input;
    private static String[] xyStart;
    private static String pathDefault = "src/input.txt";
    private static Scene s;
    private static boolean condition = true;
    private static boolean check = true;
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner in = new Scanner(System.in);

        //размер поля
        System.out.println("Укажите размер поля (формат: число строк, число столбцов)");
        field_size_input = in.nextLine();
        try {
            field_size = field_size_input.split(", ");
            if(Integer.parseInt(field_size[0]) <= 0 || Integer.parseInt(field_size[1]) <= 0){
                System.out.println("Некорректный формат поля");
                System.exit(0);
            }
        }
        catch (Exception e){
            System.out.println("Некорректный формат поля");
            System.exit(0);
        }

        //координаты начала фигуры
        System.out.println("Укажите координаты начала фигуры");
        xyStart_input = in.nextLine();
        try{
            xyStart = xyStart_input.split(", ");
            if(Integer.parseInt(xyStart[0]) <= 0 || Integer.parseInt(xyStart[1]) <= 0){
                System.out.println("Некорректный формат координат");
                System.exit(0);
            }
            else if(Integer.parseInt(xyStart[0]) > Integer.parseInt(field_size[0])){
                System.out.println("Координаты не соответствуют размеру поля");
                System.exit(0);
            }
            else if(Integer.parseInt(xyStart[1]) > Integer.parseInt(field_size[1])){
                System.out.println("Координаты не соответствуют размеру поля");
                System.exit(0);
            }
        }
        catch(Exception e){
            System.out.println("Некорректный формат координат");
            System.exit(0);
        }

        //путь к файлу + создание сцены
        System.out.println("Укажите путь к файлу с описанием фигуры (файл по умолчанияю - '1')");
        path = in.nextLine();

        System.out.println("Укажите время задержки (в секундах):");
        try {
            time = in.nextInt();
            if(time < 0){
                System.out.println("Время задержки должно быть больше 0");
                System.exit(0);
            }
        }catch (Exception e){
            System.out.println("Некорректное время задержки");
        }
        s = new Scene(field_size);
        start();

    }
    public static void start() throws InterruptedException {
        if(condition) {
            try {
                if (Objects.equals(path, "1")) {
                    TimeUnit.SECONDS.sleep(time);
                    if(check) {
                        check = false;
                        cage = read(pathDefault);
                        createCell(s, Color.black);
                        Logic.cycle(cage);
                    }
                    else{
                        createCell(s, Color.black);
                        Logic.cycle(cage);
                    }
                } else {
                    TimeUnit.SECONDS.sleep(time);
                    if(check) {
                        check = false;
                        cage = read(path);
                        createCell(s, Color.black);
                        Logic.cycle(cage);
                    }
                    else{
                        createCell(s, Color.black);
                        Logic.cycle(cage);
                    }
                }
            } catch (Exception e) {
                System.out.println("Некорректный формат директории");
                e.printStackTrace();
                System.exit(0);
            }
        }
        else {
            TimeUnit.SECONDS.sleep(time);
            createCell(s, Color.red);
        }
    }
    private static char[][] read(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        ArrayList<String> input = new ArrayList<String>();
        char[][] cage = new char[Integer.parseInt(field_size[0])][Integer.parseInt(field_size[1])];
        for(int i = 0; i < Integer.parseInt(field_size[0]); i++){
            for(int j = 0; j < Integer.parseInt(field_size[1]); j++){
                cage[i][j] = '0';
            }
        }
        Scanner s = new Scanner(fr);
        while(s.hasNextLine()){
            String line = s.nextLine();
            input.add(line);
        }
        int h = Integer.parseInt(xyStart[1]) - 1;
        int w = Integer.parseInt(xyStart[0]) - 1;
        for(int row = 0; row < input.size(); row++){
            for(int col = 0; col < input.get(row).length(); col++){
                cage[h][w] = input.get(row).charAt(col);
                w++;
                if(w > cage[h].length - 1){
                    w = 0;
                }
            }
            h++;
            w = Integer.parseInt(xyStart[0]) - 1;
            if(h > cage.length - 1){
                h = 0;
            }
        }
        return cage;
    }

    private static void createCell(Scene s, Color color) {
        Group g = new Group();
        for(int row = 0; row < cage.length; row++){
            for(int col = 0; col < cage[row].length; col++) {
                if (cage[row][col] == '1') {
                    Cell c = new Cell(col, row, color);
                    g.addCell(c);
                }
            }
        }
        s.setGroup(g);
        s.repaint();
    }
    public static void setCondition(boolean cond){
        condition = cond;
    }
    public static void setCage(char[][] cageChanged){
        cage = cageChanged;
    }

}
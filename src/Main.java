import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String field_size_input;
    private static String[] field_size;
    private static String path = "1";
    private static String xyStart_input;
    private static String[] xyStart;
    private static String pathDefault = "src/input.txt";
    private static Scene s;
    private static boolean condition = true;
    private static boolean check = true;
    public static void main(String[] args) throws FileNotFoundException {
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
        s = new Scene(field_size);
        start();

    }
    public static void start() throws FileNotFoundException {
        if(check == false){
            path = "buf.txt";
        }
        check = false;
        if(condition) {
            try {
                if (Objects.equals(path, "1")) {
                    if (read(pathDefault).size() > Integer.parseInt(field_size[0])
                            || read(pathDefault).get(0).length() > Integer.parseInt(field_size[1])) {
                        System.out.println("Фигура слишком большая");
                        System.exit(0);
                    } else {
                        createCell(pathDefault, s, Color.black);
                        TimeUnit.SECONDS.sleep(2);
                        Logic.cycle(read(pathDefault), field_size);

                    }
                } else {
                    if (read(path).size() > Integer.parseInt(field_size[0])
                            || read(path).get(0).length() > Integer.parseInt(field_size[1])) {
                        System.out.println("Фигура слишком большая");
                        System.exit(0);
                    } else {
                        createCell(path, s, Color.black);
                        TimeUnit.SECONDS.sleep(2);
                        Logic.cycle(read(path), field_size);
                    }
                }
            } catch (Exception e) {
                System.out.println("Некорректный формат директории");
                e.printStackTrace();
                System.exit(0);
            }
        }
        else {
            createCell(path, s, Color.red);
        }
    }
    private static ArrayList<String> read(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        ArrayList<String> input = new ArrayList<String>();
        Scanner s = new Scanner(fr);
        while(s.hasNextLine()){
            String line = s.nextLine();
            input.add(line);
        }
        return input;
    }

    private static void createCell(String path, Scene s, Color color) throws FileNotFoundException {
        Group g = new Group();
        for(int index = 0; index < read(path).size();index++){
            for(int index_char = 0; index_char < read(path).get(index).length(); index_char++){
                if(read(path).get(index).charAt(index_char) == '1'){
                    Cell c = new Cell(index_char,index, xyStart, color);
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
}
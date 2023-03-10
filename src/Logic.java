import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Logic {
    private static List<Integer> states = Arrays.asList(0);
    public static void cycle(ArrayList<String> text, String[] f_size) throws IOException {
        BufferedWriter fw = new BufferedWriter(new FileWriter("buf.txt"));
        String state = "";
        for(int row = 0; row < text.size(); row++){
            String buf = "";
            for(int col = 0; col < text.get(row).length(); col++) {
                int neigh = 0;
                try {
                    if (text.get(row).charAt(col + 1) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    if (text.get(row).charAt(col - 1) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    if (text.get(row + 1).charAt(col) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    if (text.get(row - 1).charAt(col) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    if (text.get(row + 1).charAt(col - 1) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {

                }
                try {
                    if (text.get(row - 1).charAt(col + 1) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    if (text.get(row - 1).charAt(col - 1) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    if (text.get(row + 1).charAt(col + 1) == '1') {
                        neigh++;
                    }
                } catch (Exception e) {
                    ;
                }
                if (text.get(row).charAt(col) == '1') {
                    if (neigh < 2 || neigh > 3) {
                        buf += "0";
                    } else {
                        buf += "1";
                    }
                } else {
                    if (neigh == 3) {
                        buf += "1";
                    } else {
                        buf += "0";
                    }
                }
            }
            state += buf;
            text.set(row, buf);
        }
        for(int i = 0; i < text.size(); i++){
            fw.write(text.get(i));
            fw.newLine();
        }
        if(states.contains(Integer.parseInt(state, 2))){
            Main.setCondition(false);
        }
        fw.flush();
        fw.close();
        Main.start();
    }
}

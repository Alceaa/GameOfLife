import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Logic {
    private static List<Integer> states = Arrays.asList(0);
    public static void cycle(ArrayList<String> text) {
        text = newLife(text);
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
                if (text.get(row).charAt(col) == '0') {
                    if (neigh == 3) {
                        buf += "1";
                    } else {
                        buf += "0";
                    }
                } else {
                    if (neigh < 2 || neigh > 3) {
                        buf += "0";
                    } else {
                        buf += "1";
                    }
                }
            }
            text.set(row, buf);
            text = clear(text);
        }
        Main.setArray(text);
        for(int i = 0; i < text.size(); i++){
            for(int j = 0; j < text.get(i).length(); j++){
                System.out.print(text.get(i).charAt(j) + " ");
            }
            System.out.println("");
        }
        Main.start();
    }
    private static ArrayList<String> newLife(ArrayList<String> text){
        //vertical
        try {
            for (int row = 1; row < text.size() - 1; row++) {
                if (text.get(row).charAt(0) == '1' && text.get(row - 1).charAt(0) == '1'
                        && text.get(row + 1).charAt(0) == '1') {
                    text.set(row, "1" + text.get(row));
                    for (int i = 0; i < row; i++) {
                        text.set(i, "0" + text.get(i));
                    }
                }
                if (text.get(row).charAt(text.get(row).length() - 1) == '1' &&
                        text.get(row - 1).charAt(text.get(row).length() - 1) == '1'
                        && text.get(row + 1).charAt(text.get(row).length() - 1) == '1') {
                    text.set(row, text.get(row) + "1");
                    for (int i = 0; i < row; i++) {
                        text.set(i, text.get(i) + "0");
                    }
                }
            }

            //horizontal
            text.add(0, "0");
            text.add("0");
            for (int col = 1; col < text.get(0).length() - 1; col++) {
                if (text.get(0).charAt(col) == '1' && text.get(0).charAt(col - 1) == '1'
                        && text.get(0).charAt(col + 1) == '1') {
                    text.set(0, text.get(0) + "1");
                } else {
                    text.set(0, text.get(0) + "0");
                }
                if (text.get(text.size() - 1).charAt(col) == '1'
                        && text.get(text.size() - 1).charAt(col - 1) == '1'
                        && text.get(text.size() - 1).charAt(col + 1) == '1') {
                    text.set(text.size() - 1, text.get(text.size() - 1) + "1");
                } else {
                    text.set(text.size() - 1, text.get(text.size() - 1) + "0");
                }
            }
        }
        catch (Exception e){
            ;
        }
        return text;
    }

    private static ArrayList<String> clear(ArrayList<String> text){
        try {
            if (!text.get(0).contains("1")) {
                text.remove(0);
            }
            if (!text.get(text.size() - 1).contains("1")) {
                text.remove(text.size() - 1);
            }
            boolean check1 = true;
            boolean check2 = true;
            for (int row = 0; row < text.size(); row++) {
                if (text.get(row).charAt(0) == '1') {
                    check1 = false;
                    break;
                }
            }
            for (int row = 0; row < text.size(); row++) {
                if (text.get(row).charAt(text.get(row).length() - 1) == '1') {
                    check2 = false;
                    break;
                }
            }
            if (check1) {
                for (int row = 0; row < text.size(); row++) {
                    text.set(row, text.get(row).substring(1));
                }
            }
            if (check2) {
                for (int row = 0; row < text.size(); row++) {
                    text.set(row, text.get(row).substring(0, text.get(row).length() - 1));
                }
            }
        }
        catch (Exception e){
            ;
        }
        return text;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Logic {
    private static List<Integer> states = Arrays.asList(0);
    public static void cycle(ArrayList<String> text) {
        //text = clear(text);
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
            text = newLife(text);
            text.set(row, buf);
            //text = clear(text);
        }
        Main.setArray(text);
        Main.start();
    }
    private static ArrayList<String> newLife(ArrayList<String> text){
        //border
        String str = new String(new char[text.get(0).length() + 2]).replace("\0", "0");
        text.add(0,str);
        text.add(str);
        for(int row = 1; row < text.size() - 1; row++){
            text.set(row, "0" + text.get(row) + "0");
        }
        for(int i = 0; i < text.size(); i++){
            for(int j = 0; j < text.get(i).length(); j++){
                System.out.print(text.get(i).charAt(j) + " ");
            }
            System.out.println("");
        }

        //generation

        //horizontal
        for(int row = 0; row < text.size(); row += text.size() - 2){
            for(int col = 1; col < text.get(row).length() - 1; col++){
                if(text.get(row).charAt(col) == '1'
                && text.get(row).charAt(col - 1) == '1'
                && text.get(row).charAt(col + 1) == '1'){
                    text.set(row + 1, text.get(row + 1).substring(0, col) + "1" + text.get(row + 1).substring(col + 1));
                }

                if(text.get(row + 1).charAt(col) == '1'
                && text.get(row + 1).charAt(col - 1) == '1'
                && text.get(row + 1).charAt(col + 1) == '1'){
                    text.set(row, text.get(row).substring(0, col) + "1" + text.get(row).substring(col + 1));
                }
            }
        }

        //vertical
        for(int row = 2; row < text.size() - 2; row++){
            if(text.get(row).charAt(1) == '1'
            && text.get(row - 1).charAt(1) == '1'
            && text.get(row + 1).charAt(1) == '1'){
                text.set(row, "1" + text.get(row).substring(1));
            }
        }
        for(int row = 2; row < text.size() - 2; row++){
            if(text.get(row).charAt(text.get(row).length() - 2) == '1'
                    && text.get(row - 1).charAt(text.get(row).length() - 2) == '1'
                    && text.get(row + 1).charAt(text.get(row).length() - 2) == '1'){
                text.set(row, text.get(row).substring(0, text.get(row).length() - 1) + "1");
            }
        }
        for(int i = 0; i < text.size(); i++){
            for(int j = 0; j < text.get(i).length(); j++){
                System.out.print(text.get(i).charAt(j) + " ");
            }
            System.out.println("");
        }
        return text;
    }

    private static ArrayList<String> clear(ArrayList<String> text){
        //horizontal
        ArrayList<String> buf = new ArrayList<String>();
        int c = 0;
        if(!text.get(0).contains("1")) {
            c++;
            text.remove(0);
        }
        if(!text.get(text.size() - 1).contains("1")){
            c++;
            text.remove(text.size() - 1);
        }
        if(!(c == 0)) {
            for (int row = 0; row < text.size() - c; row++) {
                buf.add(text.get(row));
            }
            text = buf;
        }

        //vertical
        int c1 = 0;
        int c2 = 0;
        for(int row = 1; row < text.size() - 1; row++){
            if(!(text.get(row).charAt(0) == '1')){
                c1++;
                System.out.println(c1);
            }
        }
        for(int row = 1; row < text.size() - 1; row++){
            if(!(text.get(row).charAt(text.get(row).length() - 1) == '1')){
                c2++;
            }
        }
        if(c1 == text.size() - 1){
            for(int row = 1; row < text.size() - 2; row++){
                text.set(row, text.get(row).substring(1));
            }
        }
        if(c2 == text.size() - 1){
            for(int row = 1; row < text.size() - 2; row++){
                text.set(row, text.get(row).substring(0, text.get(row).length() - 1));
            }
        }
        return text;
    }
}

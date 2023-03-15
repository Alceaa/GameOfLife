import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.deepHashCode;


public class Logic {
    private static ArrayList<Integer> states = new ArrayList<Integer>();
    public static void cycle(char[][] cage) {
        int state = deepHashCode(cage);
        System.out.println(state);
        char[][] cage_buf = new char[cage.length][cage[0].length];
        for(int row = 0; row < cage.length; row++){
            for(int col = 0; col < cage[row].length; col++){
                cage_buf[row][col] = cage[row][col];
            }
        }
        for(int row = 0; row < cage.length; row++){
            for(int col = 0; col < cage[row].length; col++){
                int neigh = 0;
                try{
                    if(cage[row][col + 1] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                try{
                    if(cage[row][col - 1] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                try{
                    if(cage[row + 1][col] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                try{
                    if(cage[row - 1][col] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                try{
                    if(cage[row + 1][col - 1] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                try{
                    if(cage[row - 1][col + 1] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                }
                try{
                    if(cage[row + 1][col + 1] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                try{
                    if(cage[row - 1][col - 1] == '1'){
                        neigh++;
                    }
                }catch(Exception e){
                    ;
                }
                if(cage[row][col] == '0' || cage[row][col] == '\0'){
                    if(neigh == 3){
                        cage_buf[row][col] = '1';
                    }
                }
                else{
                    if(neigh < 2 || neigh > 3){
                        cage_buf[row][col] = '0';
                    }
                }
            }
        }
        if(states.contains(state)){
            Main.setCondition(false);
        }
        else{
            states.add(state);
        }
        cage = cage_buf;
        Main.setCage(cage);
        Main.start();
    }
}

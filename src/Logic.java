import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Logic {
    private static List<Integer> states = Arrays.asList(0);
    public static void cycle(char[][] cage) {
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
                        System.out.println(1);
                        cage[row][col] = '1';
                    }
                }
                else{
                    if(neigh < 2 || neigh > 3){
                        cage[row][col] = '0';
                    }
                }
            }
        }
        Main.setCage(cage);
        Main.start();
    }
}

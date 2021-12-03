import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String abracadabra(){
        var rand = new Random();

        String [] abracadabra = {"a","3","j","9","2","g"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++){
            sb.append(abracadabra[rand.nextInt(abracadabra.length)]);
        }
        return sb.toString();

    }
    public static String [] separate (String str){
        String delimetr = "://";
        String [] subStr = str.split(delimetr);
        return subStr;
    }
    public static boolean check(Map <String, String>map,String generated){
        boolean flag = true;
        for(Map.Entry<String,String> entry: map.entrySet()) {
            if(generated == entry.getKey()){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static String glue(String first,String second){
        String glue = first + "://" + second + ".lk.ru";
        return glue;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        String url = sc.nextLine();
        String generated = abracadabra();

        String [] separated_mass = separate(url);
        String separated = separated_mass[1];
        Map<String, String> map = new HashMap<>();
        boolean flag = check(map,generated);

        while (flag == false){
            generated = abracadabra();
            flag = check(map,generated);
        }
            map.put(generated, separated);
        String result = glue(separated_mass[0], generated);
        System.out.println(result);
    }
}

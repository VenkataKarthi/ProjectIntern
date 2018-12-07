import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapClass {


    public void maxOccuringAlphabet(Map map, String inputString) {

        Map<Character, Integer> maplist = map;
        // maps the alphabhets with the number of occurences
        for(int index = 0; index < inputString.length(); index++)
        {
            if(maplist.containsKey(inputString.charAt(index))) {
                int count = maplist.get(inputString.charAt(index));
                maplist.put(inputString.charAt(index), ++count);
            }
            else {
                maplist.put(inputString.charAt(index), 1);
            }
        }
        // Get the maximum key value
        int max = Collections.max(maplist.values());

        for(Map.Entry<Character, Integer> entrylist : maplist.entrySet()) {

            if(max == entrylist.getValue()) {
                System.out.println("Print the maximum occured alphabet in a string");
                System.out.println(entrylist.getKey() + " : " + entrylist.getValue());
                break;
            }
        }
    }
    public static void main(String[] args) {

        HashMapClass mapObject = new HashMapClass();
        Scanner input = new Scanner(System.in);
        String inputString = input.next();
        // get a string for example "hashmaph"
        Map<Character, Integer> map = new LinkedHashMap<>();
        mapObject.maxOccuringAlphabet(map, inputString);


    }
}
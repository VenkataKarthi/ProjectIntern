
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.*;

interface india {
    abstract void indiaGoals(Integer[] goals);
}

interface  england {
    abstract void englandGoals(Integer[] goals);
}

abstract class Match implements england, india {
}
class Series extends Match{
    int indTotalScore = 0, engTotalScore = 0;
    Integer[] indiaScore1 = null;
    Integer[] englandScore1 = null;
    Integer[] result = null;
    @Override
    public void englandGoals(Integer[] engGoals) {
        englandScore1 = engGoals;
        for(Integer a : engGoals){
            System.out.print(a);
        }
        System.out.println();
    }

    @Override
    public void indiaGoals(Integer[] indGoals) {
        indiaScore1 = indGoals;
        for(Integer b : indGoals){
            System.out.print(b);
        }
        System.out.println();
    }

    public Integer[] calculation() {
        for(int eng=0,ind = 0; eng < englandScore1.length; eng++, ind++)
                if(englandScore1[eng] == indiaScore1[ind]) {
                    indTotalScore++;
                    engTotalScore++;
                }
                else if(englandScore1[eng] > indiaScore1[ind]){
                    engTotalScore += 3;
                }
                else if(englandScore1[eng] < indiaScore1[ind]){
                    indTotalScore += 3;
                }
        System.out.println("individual scores " + indTotalScore + " " + engTotalScore);
        for(int i = 0; i < 2; i++) {
            if(i==0){ result[i] = indTotalScore;}
            if(i==1){ result[i] = engTotalScore;}
            }

        return result;
    }

}
public class TeamScore extends Series{
    public static void main(String[] args) {

        Series obj = new TeamScore();
        Scanner input = new Scanner(System.in);
        Integer no_of_matches = input.nextInt();
        System.out.println();
        Integer[] indiaScore = new Integer[no_of_matches];
        Integer[] englandScore = new Integer[no_of_matches];

        for(int index1 = 0; index1 < no_of_matches; index1++){
              indiaScore[index1] = input.nextInt();
        }
        System.out.println();
        for(int index1 = 0; index1 <no_of_matches; index1++){
            englandScore[index1] = input.nextInt();
        }
        System.out.println();
        obj.indiaGoals(indiaScore);
        obj.englandGoals(englandScore);
        Integer[] results = obj.calculation();
        for(Integer goals : results) {
            System.out.println(goals);
        }
    }
}
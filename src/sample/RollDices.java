package sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class RollDices {
    private  Integer [] numberArr = {1,2,3,4,5,6};
    List<Integer> list = Arrays.asList(numberArr);
    private int value;

    public int Rolldice() {
        Collections.shuffle(list);
        this.value = list.get(3);
        return value;
    }

    public int getValue(){
        return value;
    }
}

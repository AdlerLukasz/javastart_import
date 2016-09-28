import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{
            add(1); 
            add(2);
        }};
        System.out.println(list.getClass());
    }
}

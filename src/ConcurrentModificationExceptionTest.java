import java.util.ArrayList;
import java.util.Iterator;


//对同步容器进行迭代修改时会抛出ConcurrentModificationException
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            if (integer == 2){
                list.remove(integer);
            }
        }
    }
}

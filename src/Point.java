/**
 * Point类是不可变的，因而是线程安全的
 */
public class Point {
    public final  int x , y ;
    public Point(int x, int y ){
        this.x = x ;
        this.y = y;

    }
}

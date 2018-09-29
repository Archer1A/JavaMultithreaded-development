/**
 * 线程非安全类  类似java.awt.Point 的可变Point
 */
public class MutablePoint  implements Cloneable{
    public int x ,y ;
    public MutablePoint(){ x = 0 ; y = 0;}
    public  MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }

    public Object clone(){
        MutablePoint m = null;
        try{
            m = (MutablePoint)super.clone();
        }catch (CloneNotSupportedException e ){
            e.printStackTrace();
        }
    return m;
    }

}

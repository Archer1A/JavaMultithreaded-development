import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**\
 * 将线程安全委托到ConcurrentHashMap
 */
public class DelegatingVehicleTarcker {
    private final ConcurrentMap<String, Point> locations;
    private  final Map<String, Point> unmodifiableMap;
    public  DelegatingVehicleTarcker(Map<String,Point> points){
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations(){
        return unmodifiableMap;
    }

    public Point getPointLocation(String id ){
        return locations.get(id);

    }

    public void setLocations(String id, int x ,int y){
        if (locations.replace(id, new Point(x,y)) == null){
            throw  new IllegalArgumentException("invalid vehicle name:" + id);
        }
    }

}

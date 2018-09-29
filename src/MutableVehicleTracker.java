import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 线程安全  基于监视器的机动车追踪器实现 java并发开发 63页
 */
public class MutableVehicleTracker  implements Cloneable {

    private final Map<String, MutablePoint> locations;

    public  MutableVehicleTracker(Map<String, MutablePoint> locations){
        this.locations = deepCopy(locations);
    }

    public synchronized  Map<String, MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id ){
        MutablePoint loc  = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y){
        MutablePoint loc = locations.get(id);
        if(loc == null ){
            throw new IllegalArgumentException("No suck ID :" + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static  Map<String ,MutablePoint> deepCopy(Map<String, MutablePoint> m ){
        Map<String,MutablePoint> result = new HashMap<>();
        for(String id : m.keySet()){
            result.put(id,new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result); // 返回一个不可修改的Map
    }


}

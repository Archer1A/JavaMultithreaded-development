import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 允许用户注册鼠标键盘的时间监听器的图形组建。它为每种类型的时间维护一个已注册监听器的列表，因而一个事件发生时程序会调用相应的监听器。
 * 但是鼠标事件的监听器与键盘时间的监听器之间没有关系；他们彼此独立，因此可以将visualComponent 可以将它的线程安全委托到这两个线程安全的清单上
 */
public class VisualComponent {
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();  //CopyOnWriteArrayList 线程安全的List
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();
    public void addKeyListener(KeyListener listener){
        keyListeners.add(listener);
    }
    public void addMouseListener(MouseListener listener){
        mouseListeners.add(listener);
    }
    public void removeKeyListener(KeyListener listener){
        mouseListeners.remove(listener);
    }
    public void removeMouseListener(MouseListener listener){
        mouseListeners.remove(listener);
    }

}

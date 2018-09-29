public class Main  extends  Widget{

    public  synchronized void doSomething(){

        System.out.println(toString() +  ":calling doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.doSomething();
    }
}
class Widget{
    public synchronized void doSomething(){
        System.out.println("widget doSomething");
    }

}

package default_;


/**
 * @author hum
 */
public class DefaultInAction {

    public static void main(String[] args) {
        A a = () -> 10;
        System.out.println(a.size());
        System.out.println(a.isEmpty());

        C c = new C();
        c.hello();
    }


}

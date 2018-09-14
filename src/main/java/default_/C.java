package default_;

/**
 * @author hum
 */
public class C implements B1, B2 {
    @Override
    public void hello() {
        B2.super.hello();
    }
}
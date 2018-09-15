package default_;

/**
 * @author hum
 */
public class C implements B1, B2 {
    @Override
    public void hello() {
        // B2.super 指定是B2，否则单用super 不知道是指定B1还是B2
        B2.super.hello();
    }
}
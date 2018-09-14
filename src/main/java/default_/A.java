package default_;

/**
 * @author hum
 */
public interface A {
    int size();

    default boolean isEmpty() {
        return 0 == size();
    }
}

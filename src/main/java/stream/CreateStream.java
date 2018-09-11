package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;


/**
 * @author hum
 */
public class CreateStream {
    private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("hello", "hum", "world", "stream");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "hum", "world", "stream");
    }

    private static Stream<String> createStreamFromArrays() {
        String[] strings = {"hello", "hum", "world", "stream"};
        return Arrays.stream(strings);
    }

    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("C:\\Users\\hum\\IdeaProjects\\java8\\src\\main\\java\\lambda\\ThreeFunction.java");
        try (Stream<String> streamFromFile = Files.lines(path)) {
            streamFromFile.forEach(System.out::println);
            return streamFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Integer> createStreamFromIterator() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(10);
        return stream;
    }

    private static Stream<Double> createStreamFromGenerate() {
        return Stream.generate(Math::random).limit(10);
    }

    private static Stream<Obj> createObjStreamFromGenerate() {
        return Stream.generate(new ObjSupplier()).limit(10);
    }

    static class ObjSupplier implements Supplier<Obj> {
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index, "Name->" + index);
        }
    }

    static class Obj {
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Obj{" + "name='" + name + '\'' + ", id=" + id + '}';
        }
    }

    public static void main(String[] args) {
        createStreamFromCollection().forEach(System.out::println);
        System.out.println("=======================");
        createStreamFromValues().forEach(System.out::println);
        System.out.println("=======================");
        createStreamFromArrays().forEach(System.out::println);
        System.out.println("=======================");
        Stream<String> streamFromFile = createStreamFromFile();
        System.out.println(streamFromFile);
        System.out.println("=======================");
        createStreamFromIterator().forEach(System.out::println);
        System.out.println("=======================");
        createStreamFromGenerate().forEach(System.out::println);
        System.out.println("=======================");
        createObjStreamFromGenerate().forEach(System.out::println);
    }


}

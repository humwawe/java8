package stream.spliterator;

import java.util.Optional;


/**
 * @author hum
 */
public class SpliteratorInAction {

    private static String text = "Lorem ipsum. Cras scelerisque vel ligula at suscipit. Maecenas non ipsum quis est malesuada lobortis. Cras porta tortor elit, ut dictum ipsum pellentesque in. Mauris ut sollicitudin tellus.\n" +
            "\n" +
            "Integer dictum,  eget tellus. Quisque porttitor, dolor quis porta malesuada, turpis purus vestibulum mi, quis tempus lectus tortor id arcu. Vivamus varius egestas elit in hendrerit.\n" +
            "\n" +
            "Quisque lacinia  tincidunt, orci arcu gravida metus, ac blandit neque mi non nisi. Aliquam dapibus eros nec metus vestibulum egestas ac feugiat elit. Donec ut condimentum nunc.\n" +
            "\n" +
            "Morbi eu  mi interdum, semper sem vel, varius felis. Curabitur tincidunt eleifend leo, eget tempus mi ultricies vitae. Cras a turpis viverra, suscipit quam ut, porta turpis.\n" +
            "\n" +
            "Phasellus  pharetra convallis. Quisque laoreet risus sit amet tristique porttitor. Sed accumsan venenatis justo non dapibus. Suspendisse ac est erat.\n" +
            "\n" +
            "In porta faucibus suscipit. Proin a  scelerisque justo eu risus venenatis semper. Nam vitae porttitor justo.\n" +
            "\n" +
            "Fusce a sagittis lorem. Nam at est. Suspendisse faucibus tincidunt justo, eget mollis odio lobortis id.\n" +
            "\n" +
            "Maecenas dictum arcu nec nisi sollicitudin, . Donec tincidunt lorem id condimentum interdum. In luctus enim eget lacinia auctor.";


    public static void main(String[] args) {
        MySpliteratorText mySpliteratorText = new MySpliteratorText(text);
        Optional.ofNullable(mySpliteratorText.parallelStream().count())
                .ifPresent(System.out::println);

        mySpliteratorText.stream().forEach(System.out::println);

        mySpliteratorText.parallelStream().filter(s -> !"".equals(s)).forEach(System.out::println);


    }

}

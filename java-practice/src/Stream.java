import java.util.ArrayList;
import java.util.Arrays;

public class Stream {
    public static void main(String[] args) {
        ArrayList<User> userArrayList = new ArrayList<User>();

        userArrayList.add(new User(0L, "sumin"));
        userArrayList.add(new User(1L, "minsu"));
        userArrayList.add(new User(2L, "sam"));

        userArrayList.stream()
                .map(User::getName)
                .filter(name -> name.contains("u"))
                .forEach(System.out::println);

    }
}

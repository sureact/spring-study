import java.util.ArrayList;
import java.util.Arrays;

public class Stream {
    public static void main(String[] args) {
        ArrayList<User> userArrayList = new ArrayList<User>();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry"));

        userArrayList.add(new User(0L, "sumin"));
        userArrayList.add(new User(1L, "minsu"));
        userArrayList.add(new User(2L, "sam"));

        userArrayList.stream()
                .map(User::getName)
                .filter(name -> name.contains("u"))
                .forEach(System.out::println);

        list.stream()
                .filter(t->t.contains("a"))
                .forEach(System.out::println);
    }
}

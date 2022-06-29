import java.util.ArrayList;

public class Stream {

    public void runStream(){
        ArrayList<User> userArrayList = new ArrayList<User>();

        userArrayList.add(new User(0L, "sumin"));
        userArrayList.add(new User(1L, "minsu"));
        userArrayList.add(new User(2L, "sam"));
        userArrayList.add(new User(3L, "milk717"));

        userArrayList.stream()
                .map(User::getName)
                .filter(name->name.contains("u"))
                .forEach(System.out::println);

    }

}

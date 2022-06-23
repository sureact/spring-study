import java.util.ArrayList;

public class Stream {
    public static void main(String[] args) {
        ArrayList<User> userArrayList = new ArrayList<User>();

        userArrayList.add(new User(0, "sumin"));
        userArrayList.add(new User(1, "minsu"));
        userArrayList.add(new User(2, "sam"));

        userArrayList.stream().filter(name -> name.getName().contains("u"));
        System.out.println();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2CollectionDif {
    public static void main(String[] args) {
        List<String> col1 = new ArrayList<>(Arrays.asList("Alex", "Dima", "Kate", "Galina", "Ivan"));
        List<String> col2 = new ArrayList<>(Arrays.asList("Dima", "Ivan", "Kate"));

        for (String n : col2) {
            col1.remove(n);
        }
        System.out.println(col1);
    }
}

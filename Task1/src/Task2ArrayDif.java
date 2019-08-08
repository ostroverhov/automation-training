import java.util.Arrays;

public class Task2ArrayDif {
    public static void main(String[] args) {
        String[] arr1 = {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String[] arr2 = {"Dima", "Ivan", "Kate"};

        int counter = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (String name2 : arr2) {
                if (arr1[i].equals(name2)) {
                    counter++;
                    arr1[i] = "toDell";
                }
            }
        }

        String[] newArr = new String[arr1.length - counter];

        int i = 0;
        for (String name1 : arr1) {
            if (!name1.equals("toDell")) {
                newArr[i] = name1;
                i++;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}

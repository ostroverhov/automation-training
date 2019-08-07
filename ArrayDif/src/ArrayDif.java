import java.util.Arrays;

public class ArrayDif {
    public static void main(String[] args) {
        String[] arr1 = {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String[] arr2 = {"Dima", "Ivan", "Kate"};

        int counter = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])){
                    counter++;
                }
            }
        }
        int newLenth = arr1.length - counter;
        String[] newArr = new String[newLenth];

        System.out.println(newLenth);

        for (int k = 0; k<newLenth; k++){
            for (int y = 0; y < arr1.length; y++) {
                for (int x = 0; x < arr2.length; x++) {
                    if (arr1[y].equals(arr2[x]));
                    else {
                        newArr[k] = arr1[y];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}

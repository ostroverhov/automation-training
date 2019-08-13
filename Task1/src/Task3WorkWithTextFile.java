import java.io.*;
import java.util.*;

public class Task3WorkWithTextFile {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String pathToTheFile = "Task1/src/doc1Task1.txt";
        System.out.println("Input number of strings to select: ");
        String toSelectStr = in.next();
        int toSelect;
        int toSelectDefault = 10;
        try {
            toSelect = Integer.parseInt(toSelectStr);
        } catch (NumberFormatException e) {
            toSelect = 0;
        }
        if (toSelect > 0) {
            workWithFile(pathToTheFile, toSelect);
        } else workWithFile(pathToTheFile, toSelectDefault);
    }

    private static String workWithFile(String pathToTheFile, int toSelect) throws IOException {
        FileReader fileReader = new FileReader(pathToTheFile);  //чтение файла
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        if (toSelect <= lines.size()) {  //проверка размерности полученного и требуемого
            Set<String> resultLines = new HashSet<>();
            Random random = new Random();
            while (resultLines.size() < toSelect) {
                int numberLines = random.nextInt(lines.size());  //диапазон от 0 до размера lines
                resultLines.add(lines.get(numberLines));
            }

            String newNameFile = pathToTheFile.substring(0, pathToTheFile.lastIndexOf(".")) + "_res" + pathToTheFile.substring(pathToTheFile.lastIndexOf("."));
            FileWriter fileWriter = new FileWriter(new File(newNameFile));  //запись нового с новым названием
            for (String s : resultLines) {
                fileWriter.write(s);
                fileWriter.write("\n");
                lines.remove(s);
            }
            fileWriter.flush();

            FileWriter fileWriterPrevious = new FileWriter(new File(pathToTheFile));  //перезапись старого с удаленными строками
            for (String s : lines) {
                fileWriterPrevious.write(s);
                fileWriterPrevious.write("\n");
            }
            fileWriterPrevious.flush();
            System.out.println(newNameFile);
            return newNameFile;
        } else {
            System.out.println("всего в таблице " + lines.size() + " строк");
            return null;
        }
    }
}

package framework;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Utils {
    public static Boolean regexpHandler(String patternWord, String string){
        Pattern pattern = Pattern.compile(patternWord.toLowerCase());
        String stringInLowerCase = string.toLowerCase();
        return pattern.matcher(stringInLowerCase).find();
    }

    public static int getRandom(List<WebElement> catalog){
        Random random = new Random();
        int i = random.nextInt(catalog.size());
        return i;
    }
}

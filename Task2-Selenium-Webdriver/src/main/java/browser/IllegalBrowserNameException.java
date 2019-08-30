package browser;

public class IllegalBrowserNameException extends IllegalArgumentException {

    public IllegalBrowserNameException() {
        System.out.println("Выберите браузер chrome / firefox");
    }
}

package browser;

public class IllegalBrowserNameException extends Exception {

    public IllegalBrowserNameException() {
        super("Выберите браузер chrome / firefox");
    }
}

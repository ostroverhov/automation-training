package app;

public class Game {
    private String nameGame;
    private String discountRate;
    private String initialPrice;
    private String discountPrice;

    public Game(String nameGame, String discountRate, String initialPrice, String discountPrice) {
        this.nameGame = nameGame;
        this.discountRate = discountRate;
        this.initialPrice = initialPrice;
        this.discountPrice = discountPrice;
    }

    public String getNameGame() {
        return nameGame.toLowerCase();
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public String getInitialPrice() {
        return initialPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }
}

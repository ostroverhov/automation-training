package app.form;

import framework.elements.SubMenu;
import framework.elements.Tab;
import framework.utils.Discount;
import framework.utils.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TabsMenu {
    String locate = " на TabsMenu";

    String tabTopSellerMenuLocator = "//div[@id='tab_select_TopSellers']";
    String gamesFromTopSellerTab = "//div[@id='TopSellersTable']//div[@class='discount_block tab_item_discount']";
    String discountLocator = ".//div[@class='discount_pct']";
    String gameNameLocator = "..//div[@class='tab_item_name']";
    String initialPriceLocator = ".//div[@class='discount_original_price']";
    String discountedPriceLocator = ".//div[@class='discount_final_price']";
    String gameWithMaxMinDiscount = "//div[@class='tab_item_name'][contains(text(), '%s')]";

    String nameGame;
    String discountRate;
    String initialPrice;
    String discountPrice;

    private Tab getTabTopSeller() {
        return new Tab(tabTopSellerMenuLocator, "TabTopSeller" + locate);
    }

    public void clickToTabTopSeller() {
        getTabTopSeller().clickElement();
    }

    public boolean isDisplayedTabTopSeller(){
        return getTabTopSeller().isDispl();
    }

    private SubMenu getSubMenu() {
        return new SubMenu(gamesFromTopSellerTab, "SubMenu" + locate);
    }

    public void getGameMaxDiscountFromTopSellerTab() {
        MyLogger.info("Получение данных об игре с максимальной скидкой");
        List<WebElement> gamesWithDiscountfield = getSubMenu().getElements();
        List<Integer> discount = new ArrayList<>();
        for (WebElement w : gamesWithDiscountfield) {
            discount.add(Discount.getNumberDiscount(w.getText()));
        }
        int indexGameWithMaxDiscount = Discount.indexMimDiscountGame(discount);
        nameGame = gamesWithDiscountfield.get(indexGameWithMaxDiscount).findElement(By.xpath(gameNameLocator)).getText();
        discountRate = gamesWithDiscountfield.get(indexGameWithMaxDiscount).findElement(By.xpath(discountLocator)).getText();
        initialPrice = gamesWithDiscountfield.get(indexGameWithMaxDiscount).findElement(By.xpath(initialPriceLocator)).getText();
        discountPrice = gamesWithDiscountfield.get(indexGameWithMaxDiscount).findElement(By.xpath(discountedPriceLocator)).getText();
    }

    public void getGameMinDiscountFromTopSellerTab() {
        MyLogger.info("Получениеданных об игре с минимальной скидкой");
        List<WebElement> gamesWithDiscountfield = getSubMenu().getElements();
        List<Integer> discount = new ArrayList<>();
        for (WebElement w : gamesWithDiscountfield) {
            discount.add(Discount.getNumberDiscount(w.getText()));
        }
        int indexGameWithMinDiscount = Discount.indexMinDiscountGame(discount);
        nameGame = gamesWithDiscountfield.get(indexGameWithMinDiscount).findElement(By.xpath(gameNameLocator)).getText();
        discountRate = gamesWithDiscountfield.get(indexGameWithMinDiscount).findElement(By.xpath(discountLocator)).getText();
        initialPrice = gamesWithDiscountfield.get(indexGameWithMinDiscount).findElement(By.xpath(initialPriceLocator)).getText();
        discountPrice = gamesWithDiscountfield.get(indexGameWithMinDiscount).findElement(By.xpath(discountedPriceLocator)).getText();
    }

    public void selectMaxMinDiscount(String select){
        if (select.equalsIgnoreCase("max")){
            getGameMaxDiscountFromTopSellerTab();
        }
        if (select.equalsIgnoreCase("min")){
            getGameMinDiscountFromTopSellerTab();
        }
    }

    public String getName(){
        return nameGame.toLowerCase();
    }

    public String getDiscount(){
        return discountRate;
    }

    public String getInitialPrice(){
        return initialPrice;
    }

    public String getDiscountPrice(){
        return discountPrice;
    }

    private Tab getGameTabWithMaxMinDiscount() {
        return new Tab(String.format(gameWithMaxMinDiscount, nameGame), " GameTabWithMaxMinDiscount" + locate);
    }

    public void clickGame() {
        getGameTabWithMaxMinDiscount().clickElement();
    }
}

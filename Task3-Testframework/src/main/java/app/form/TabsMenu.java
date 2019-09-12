package app.form;

import app.Game;
import framework.elements.SubMenu;
import framework.elements.Tab;
import app.projectUtils.Discount;
import framework.utils.MyLogger;

import java.util.List;

public class TabsMenu {
    private String locate = " on TabsMenu";
    private String nameGame;
    private String tabTopSellerMenuLocator = "//div[@id='tab_select_TopSellers']";
    private String gamesFromTopSellerTab = "//div[@id='TopSellersTable']//div[@class='discount_block tab_item_discount']";
    private String discountLocator = ".//div[@class='discount_pct']";
    private String gameNameLocator = "..//div[@class='tab_item_name']";
    private String initialPriceLocator = ".//div[@class='discount_original_price']";
    private String discountedPriceLocator = ".//div[@class='discount_final_price']";
    private String gameWithMaxMinDiscount = "//div[@class='tab_item_name'][contains(text(), '%s')]";

    private Tab tabTopSeller = new Tab(tabTopSellerMenuLocator, "TabTopSeller" + locate);
    private SubMenu subMenu = new SubMenu(gamesFromTopSellerTab, "SubMenu" + locate);

    public void clickToTabTopSeller() {
        tabTopSeller.clickElement();
    }

    public boolean isDisplayedTabTopSeller() {
        return tabTopSeller.isDispl();
    }

    /**
     * Create new object Car with max or min discount from list of WebElements in dependency of param selectDiscount
     * @param selectDiscount - selected type of discount, max or min
     * @return Game - object with parameters: name, discount, initial price, discount price
     */
    public Game getGameDiscountFromTopSellerTab(String selectDiscount) {
        MyLogger.info("Get game with " + selectDiscount + " discount");

        List<Integer> discount = SubMenu.getListDiscountfromSubMenu(subMenu.getElements());
        int indexGameWithDiscount = 0;
        if (selectDiscount.equalsIgnoreCase("max")) {
            indexGameWithDiscount = Discount.indexMaxDiscountGame(discount);
        }
        if (selectDiscount.equalsIgnoreCase("min")) {
            indexGameWithDiscount = Discount.indexMinDiscountGame(discount);
        }

        nameGame = SubMenu.getTextSubMenuItem(indexGameWithDiscount, gameNameLocator, subMenu.getElements());
        String discountRate = SubMenu.getTextSubMenuItem(indexGameWithDiscount, discountLocator, subMenu.getElements());
        String initialPrice = SubMenu.getTextSubMenuItem(indexGameWithDiscount, initialPriceLocator, subMenu.getElements());
        String discountPrice = SubMenu.getTextSubMenuItem(indexGameWithDiscount, discountedPriceLocator, subMenu.getElements());

        return new Game(nameGame, discountRate, initialPrice, discountPrice);
    }

    private Tab getGameTabWithMaxMinDiscount() {
        return new Tab(String.format(gameWithMaxMinDiscount, nameGame), " GameTabWithMaxMinDiscount" + locate);
    }

    public void clickGame() {
        getGameTabWithMaxMinDiscount().clickElement();
    }
}

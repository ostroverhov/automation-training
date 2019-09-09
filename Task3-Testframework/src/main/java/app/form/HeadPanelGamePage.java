package app.form;

import framework.elements.Panel;

public class HeadPanelGamePage {
    private String locate = " on HeadPanelGamePage";
    private String panelNameLocator = "//div[@class='game_area_purchase_game']//h1";
    private String panelDiscountRateLocator = "//div[@class='discount_pct']";
    private String panelInitialPriceLocator = "//div[@class='discount_original_price']";
    private String panelDiscountPriceLocator = "//div[@class='discount_final_price']";

    private Panel panelName = new Panel(panelNameLocator, "PanelName" + locate);
    private Panel panelDiscount = new Panel(panelDiscountRateLocator, "PanelName" + locate);
    private Panel panelInitialPrice = new Panel(panelInitialPriceLocator, "PanelName" + locate);
    private Panel panelDiscountPrice = new Panel(panelDiscountPriceLocator, "PanelName" + locate);

    public String getName() {
        return panelName.getTextFromElement().toLowerCase();
    }

    public String getDiscount() {
        return panelDiscount.getTextFromElement();
    }

    public String getInitialPrice() {
        return panelInitialPrice.getTextFromElement();
    }

    public String getDiscountPrice() {
        return panelDiscountPrice.getTextFromElement().split(" USD")[0];
    }
}

package app.form;

import framework.elements.Panel;

public class HeadPanelGamePage {
    String locate = " на HeadPanelGamePage";
    String panelNameLocator = "//div[@class='game_area_purchase_game']//h1";
    String panelDiscountRate = "//div[@class='discount_pct']";
    String panelInitialPrice = "//div[@class='discount_original_price']";
    String panelDiscountPrice = "//div[@class='discount_final_price']";

    private Panel getPanelName() {
        return new Panel(panelNameLocator, "PanelName" + locate);
    }

    private Panel getPanelDiscount() {
        return new Panel(panelDiscountRate, "PanelDiscount" + locate);
    }

    private Panel getPanelInitialPrice() {
        return new Panel(panelInitialPrice, "PanelInitialPrice" + locate);
    }

    private Panel getPanelDiscountPrice() {
        return new Panel(panelDiscountPrice, "PanelDiscountPrice" + locate);
    }

    public String getName(){
        return getPanelName().getTextFromElement().toLowerCase();
    }

    public String getDiscount(){
        return getPanelDiscount().getTextFromElement();
    }

    public String getInitialPrice(){
        return getPanelInitialPrice().getTextFromElement();
    }

    public String getDiscountPrice(){
        return getPanelDiscountPrice().getTextFromElement().split(" USD")[0];
    }
}

package guru.qa.niffler.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    private final SelenideElement btnSwitch = $(".MuiSwitch-input");
    private final ElementsCollection muiChip = $$(".MuiChip-filled.MuiChip-colorDefault");
    private final ElementsCollection muiChipActive = $$(".MuiChip-filled.MuiChip-colorPrimary");


    public ProfilePage clickBtnSwitch() {
        btnSwitch.click();
        return this;
    }


    public ProfilePage checkArchivedCategory(String category) {
        clickBtnSwitch();
        muiChip.find(text(category)).shouldBe(visible);
        return this;
    }

    public ProfilePage checkActiveCategory(String category){
        muiChipActive.find(text(category)).shouldBe(visible);
        return this;
    }
}

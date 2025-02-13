package guru.qa.niffler.components;

import com.codeborne.selenide.SelenideElement;
import guru.qa.niffler.page.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class MainTopBar {
    private final SelenideElement btnPersonIcon = $("[data-testid='PersonIcon']");
    private final SelenideElement btnProfile = $("[href='/profile']");

    public MainTopBar clickBtnPersonIcon(){
        btnPersonIcon.click();
        return this;
    }

    public ProfilePage clickBtnProfile(){
        btnProfile.click();
        return new ProfilePage();
    }





}

package guru.qa.niffler.components;

import com.codeborne.selenide.SelenideElement;
import guru.qa.niffler.page.AllPeoplePage;
import guru.qa.niffler.page.FriendsPage;
import guru.qa.niffler.page.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class MainTopBar {
    private final SelenideElement btnPersonIcon = $("[data-testid='PersonIcon']");
    private final SelenideElement btnProfile = $("[href='/profile']");
    private final SelenideElement btnFriends = $("[href='/people/friends']");
    private final SelenideElement btnAllFriends = $("[href='/people/all']");


    /**
     * Нажимаем на "Иконку"
     * @return боковое меню
     */
    public MainTopBar clickBtnPersonIcon() {
        btnPersonIcon.click();
        return this;
    }

    /**
     * Нажимаем на кнопку "Профиль"
     * @return страницу с профилем
     */
    public ProfilePage clickBtnProfile() {
        btnProfile.click();
        return new ProfilePage();
    }

    /**
     * Нажимаем на кнопку "Друзья"
     * @return страницу с друзьями
     */
    public FriendsPage clickBtnFriends(){
        btnFriends.click();
        return new FriendsPage();
    }

    public AllPeoplePage clickAllPeople(){
        btnAllFriends.click();
        return new AllPeoplePage();
    }


}

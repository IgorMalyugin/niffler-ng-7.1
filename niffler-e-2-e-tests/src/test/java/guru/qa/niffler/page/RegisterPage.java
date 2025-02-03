package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    private final SelenideElement userNameInput = $(By.id("username"));
    private final SelenideElement passwordInput = $(By.id("password"));
    private final SelenideElement passwordSubmit = $(By.id("passwordSubmit"));
    private final SelenideElement saveBtn = $("button[type='submit']");
    private final SelenideElement registrationText = $(byText("Congratulations! You've registered!"));
    private final SelenideElement messageError = $(".form__error");

    public RegisterPage setUserName(String name) {
        userNameInput.setValue(name);
        return this;
    }

    public RegisterPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public RegisterPage setPasswordSubmit(String password) {
        passwordSubmit.setValue(password);
        return this;
    }

    public RegisterPage clickSave() {
        saveBtn.click();
        return new RegisterPage();
    }

    public void checkSuccessRegistration() {
        registrationText.shouldBe(visible);
    }

    public RegisterPage checkError(String name){
        messageError.shouldHave(text(name));
        return this;
    }

}

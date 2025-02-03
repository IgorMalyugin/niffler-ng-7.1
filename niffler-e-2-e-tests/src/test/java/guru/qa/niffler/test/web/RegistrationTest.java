package guru.qa.niffler.test.web;

import com.codeborne.selenide.Selenide;
import guru.qa.niffler.config.Config;
import guru.qa.niffler.page.LoginPage;
import org.junit.jupiter.api.Test;

import static guru.qa.niffler.utils.RandomDataUtils.randomUsername;

public class RegistrationTest {

    private static final Config CFG = Config.getInstance();

    @Test
    void shouldRegisterNewUser() {
        String name = randomUsername();
        String password = "12345";
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .createNewAccount()
                .setUserName(name)
                .setPassword(password)
                .setPasswordSubmit(password)
                .clickSave()
                .checkSuccessRegistration();

    }

    @Test
    void shouldNotRegisterUserWithExistingUsername() {
        String name = "Igor";
        String password = "123";
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .createNewAccount()
                .setUserName(name)
                .setPassword(password)
                .setPasswordSubmit(password)
                .clickSave()
                .checkError("Username `" + name + "` already exists");
    }

    @Test
    void shouldShowErrorIfPasswordAndConfirmPasswordAreNotEqual() {
        String name = randomUsername();
        String password = "1234";
        String incorrectPas = "12345";
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .createNewAccount()
                .setUserName(name)
                .setPassword(password)
                .setPasswordSubmit(incorrectPas)
                .clickSave()
                .checkError("Passwords should be equal");
    }
}

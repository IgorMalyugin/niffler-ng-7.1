package guru.qa.niffler.test.web;

import com.codeborne.selenide.Selenide;
import guru.qa.niffler.config.Config;
import guru.qa.niffler.jupiter.annotation.Category;
import guru.qa.niffler.jupiter.annotation.User;
import guru.qa.niffler.model.CategoryJson;
import guru.qa.niffler.page.LoginPage;
import org.junit.jupiter.api.Test;

public class ProfileTest {

    private static final guru.qa.niffler.config.Config CFG = Config.getInstance();

    @User(
            username = "Igor",
            categories = @Category(
                    archived = true
            )

    )

    @Test
    void archivedCategoryShouldPresentInCategoriesList(CategoryJson category) {
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .login("Igor", "123")
                .mainTopBar
                .clickBtnPersonIcon()
                .clickBtnProfile()
                .checkArchivedCategory(category.name());

    }

    @User(
            username = "Igor",
            categories = @Category(
                    archived = false
            )

    )

    @Test
    void activeCategoryShouldPresentInCategoriesList(CategoryJson category) {
        Selenide.open(CFG.frontUrl(), LoginPage.class)
                .login("Igor", "123")
                .mainTopBar
                .clickBtnPersonIcon()
                .clickBtnProfile()
                .checkActiveCategory(category.name());
    }
}

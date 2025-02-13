package guru.qa.niffler.page;

import com.codeborne.selenide.ElementsCollection;
import guru.qa.niffler.components.MainTopBar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainTopBar mainTopBar = new MainTopBar();

    private final ElementsCollection tableRows = $("#spendings tbody").$$("tr");

    public EditSpendingPage editSpending(String spendingDescription) {
        tableRows.find(text(spendingDescription)).$$("td").get(5).click();
        return new EditSpendingPage();
    }

    public void checkThatTableContainsSpending(String spendingDescription) {
        tableRows.find(text(spendingDescription)).should(visible);
    }
}

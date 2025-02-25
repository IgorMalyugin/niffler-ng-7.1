package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FriendsPage {

    private final SelenideElement friendsTable = $(By.xpath("//p[text()='There are no users yet']"));
    private final SelenideElement requestsTable = $("#requests");

    public FriendsPage clickFriends(){
        return this;
    }

    public FriendsPage clickAllPeople(){
        return this;
    }

    public FriendsPage checkFriends(String username){
        $x("//p[text()='" + username + "']").shouldBe(visible);
        return this;
    }

    public FriendsPage checkNoExistingFriends(){
        friendsTable.shouldBe(visible);
        return this;
    }

    public FriendsPage checkExistingInvitations(String expectedUsernames){
        requestsTable.$$("tr").shouldHave(textsInAnyOrder(expectedUsernames));
        return this;
    }

}

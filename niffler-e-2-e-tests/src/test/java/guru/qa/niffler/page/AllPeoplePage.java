package guru.qa.niffler.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AllPeoplePage {


    public AllPeoplePage checkInvitationSentToUser(String username){
        $("#all").$$("tr").find(text(username)).shouldHave(text("Waiting..."));
        return new AllPeoplePage();
    }
}

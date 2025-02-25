package guru.qa.niffler.page;

import static com.codeborne.selenide.Selenide.$x;

public class AllPeoplePage {


    public AllPeoplePage checkInvitationSentToUser(String username){
        $x("//p[text()='" + username + "']/../../..//span[text()='Waiting...']");
        return new AllPeoplePage();
    }
}

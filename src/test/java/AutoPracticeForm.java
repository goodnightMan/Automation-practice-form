import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeForm {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

  /*  @AfterEach
    void closeBrowser() {
        closeWebDriver();
   }
  */
    @Test
    void selenidePracticeForm() {
        String fName = "Bill";
        String lName = "Yellow";
        String uMail = "somewhere@la.fa";
        String uNumber = "4432568000";
        String subject = "Arts";
        String currAddr = "home";
        String state = "Rajasthan";
        String city = "Jaipur";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(fName);
        $("#lastName").setValue(lName);
        $("#userEmail").setValue(uMail);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(uNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day.react-datepicker__day--015").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpeg"));
        $("#currentAddress").setValue(currAddr);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldHave(
                text("Student Name"), text(fName + " " + lName),
                text("Student Email"), text(uMail),
                text("Gender"), text("Male"),
                text("Mobile"), text(uMail),
                text("Date of Birth"), text("15 April,1999"),
                text("Subjects"), text(subject),
                text("Hobbies"), text("Sports"),
                text("Picture"), text("1.jpeg"),
                text("Address"), text(currAddr),
                text("State and City"), text(state + " " + city)
        );
    }
}

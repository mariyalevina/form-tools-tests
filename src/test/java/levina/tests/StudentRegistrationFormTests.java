package levina.tests;

import com.codeborne.selenide.Configuration;
import levina.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {
     open("/automation-practice-form");
     $("#firstName").setValue("Mariya");
     $("#lastName").setValue("Levina");
     $("#userEmail").setValue("mariya.levina@simbirsoft.com");
     $("#genterWrapper").$(byText("Female")).click();
     $("#userNumber").setValue("1234567890");

     $("#dateOfBirthInput").click();
     $(".react-datepicker__month-select").selectOption("November");
     $(".react-datepicker__year-select").selectOption("2022");
     $(".react-datepicker__day--008:not(.react-datepicker__day--outside-month)").click();

      $("#subjectsInput").setValue("Chemistry").pressEnter();
      $("#hobbiesWrapper").$(byText("Sports")).click();
      $("#uploadPicture").uploadFromClasspath("img/123.png");

        $("#currentAddress").setValue("Ulyanovsk, st. Kamyshinskaya 105");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Mariya Levina"), text("mariya.levina@simbirsoft.com"),
                text("Female"), text("1234567890"), text("08 November,2022"), text("Chemistry"), text("Sports"),
                text("123.png"), text("Ulyanovsk, st. Kamyshinskaya 105"), text("NCR Delhi"));
    }
}

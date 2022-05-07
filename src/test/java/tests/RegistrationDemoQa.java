package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationDemoQa {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successPracticeFormTest(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Sam");
        $("#lastName").setValue("Vin");
        $("#userEmail").setValue("xxx@xx.xx");
        $(".custom-control-label").shouldHave(text("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--010").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-1").parent().click();

        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("bla-bla-bla");
        $("#state").scrollTo().click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").scrollTo().click();

        $(".table-responsive").shouldHave(
                text("Sam Vin"),
                text("xxx@xx.xx"),
                text("Male"),
                text("9999999999"),
                text("10 May,1993"),
                text("English"),
                text("Sports"),
                text("1.png"),
                text("bla-bla-bla"),
                text("NCR Delhi")
        );

        $("#closeLargeModal").click();

    }

}

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationDemoQaWithPageObject {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successPracticeFormTest(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName("Sam")
                .setLastName("Vin")
                .setUserEmail("xxx@xx.xx")
                .setGender("Male")
                .userNumber("99999999999")
                .dateOfBirthInput("May", "1993", "10")
                .setSubjects("English")
                .setHobbies("1")
                .uploadPicture("1.png")
                .setAddress("bla-bla-bla","NCR","Delhi")
                .checkResult();


    }

}

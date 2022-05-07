package pages;

import tests.RegistrationDemoQa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);
        ;
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(".custom-control-label").shouldHave(text(gender)).click();
        return this;
    }

    public RegistrationPage userNumber(String number) {
        $("#userNumber").setValue("9999999999");
        return this;
    }

    public RegistrationPage dateOfBirthInput(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String numberHobbies) {
        $("#hobbies-checkbox-" + numberHobbies).parent().click();
        return this;
    }

    public RegistrationPage uploadPicture(String addressPicrure) {
        $("#uploadPicture").uploadFromClasspath("1.png");
        return this;
    }

    public RegistrationPage setAddress(String currentAddress, String state, String city) {
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage checkResult() {
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
        return this;
    }
}


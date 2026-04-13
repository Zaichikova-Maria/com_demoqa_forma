package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.TestData.*;

public class FormaTests extends TestBase {

    @Test
    void successfullFormaTest() {
        open(" ");

        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);

        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $("#currentAddress").setValue(currentAddress);
        $("#genterWrapper").$(byText(gender)).click();


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();

        $("#uploadPicture").uploadFromClasspath(photo);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

// Проверка формы
        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName),text(lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));

        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day),text(month),text(year));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state),text(city));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("foto.jpg"));


    }




        @Test
        void negativeFormaTest() {
            open(" ");

            executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);

            $$(".card-body").findBy(text("Forms")).click();
            $$(".router-link").findBy(text("Practice Form")).click();

            $("#submit").click();

         $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
         $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
         $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
         $("#genterWrapper").$(byText("Male")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));


}
}

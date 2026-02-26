package test;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormaTests extends TestBase {

    @Test
    void successfullFormaTest() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Student Registration Form"));


        $("id=[firstName]").setValue("Maria");
        $("id=[lastName]").setValue("Zaychikova");
        $("id=[userEmail]").setValue("zaychikova@mail.com");
        $("id=[userNumber]").setValue("+12345678901");
        $("id=[currentAddress]").setValue("adress");
        $("id=[genterWrapper]").$(byText("Femail")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("id=[subjectsInput]").setValue("Math").pressEnter();
        $("id=[hobbiesWrapper]").$(byText("Music")).click();
        $("id=[uploadPicture]").uploadFile(new File("src/test/resources/img/foto.png"));
        $("#state").click();
        $("id=[stateCity-wrapper]").$(byText("NCR")).click();
        $("#city").click();
        $("id=[stateCity-wrapper]").$(byText("NCR")).click();
        $("id=[stateCity-wrapper]").$(byText("Noida")).click();
        $("#submit").click();

}
}

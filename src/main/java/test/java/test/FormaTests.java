package test;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static test.testsdata.TestData.*;

public class FormaTests extends TestBase {

    @Test
    void successfullFormaTest() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Student Registration Form"));


       //String firstName = "Maria";
        //String lastName = "Zaychikova";
        //String userEmail = "zaychikova@mail.com";
        //String userNumber = "+12345678901";
        // String currentAddress = "adress";



        $("id=[firstName]").setValue(firstName);
        $("id=[lastName]").setValue(lastName);
        $("id=[userEmail]").setValue(userEmail);
        $("id=[userNumber]").setValue(userNumber);
        $("id=[currentAddress]").setValue(currentAddress);
        $("id=[genterWrapper]").$(byText("Femail")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("id=[subjectsInput]").setValue("Math").pressEnter();
        $("id=[hobbiesWrapper]").$(byText("Music")).click();
        $("id=[uploadPicture]").uploadFile(new File("src/test/resources/img/foto.jpg"));
        $("#state").click();
        $("id=[stateCity-wrapper]").$(byText("NCR")).click();
        $("#city").click();
        $("id=[stateCity-wrapper]").$(byText("NCR")).click();
        $("id=[stateCity-wrapper]").$(byText("Noida")).click();
        $("#submit").click();

}
}

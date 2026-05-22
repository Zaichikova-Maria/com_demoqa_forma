import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import testData.data.Language;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;


public class ParameterizeTests extends TestBase {

//    @BeforeEach
//    void setUp() {
//        open("https://uniofweb.ru/");
//    }

    @ParameterizedTest (name = "Тест с пользователем: {0} {1} {2}")

    @CsvSource ( value = {
            "Александр, +79205555555, дизайн проект",
            "Василий, +79205551111, разработка"
    })

    @DisplayName("Проверка формы обратного звонка CsvSource")
    @Tag("Csv")
    void fillFormWithCsvSourceTest(String firstName, String userNumber, String currentAddress) {
        open("https://uniofweb.ru/");

        $(".callback-wrapper").click();
        $("[name=form_text_8]").setValue(firstName).pressEnter();
        $("[name=form_text_9]").setValue(userNumber).pressEnter();
        $("[name=form_textarea_10]").setValue(currentAddress).pressEnter();
        $(".submit-wrapper").click();

        $(".form-note").shouldHave(text("Спасибо! Ваша заявка"));
    }



    @ParameterizedTest (name = "Тест с пользователем: {0} {1} {2}")

    @CsvFileSource(resources = "/fillFormWithCsvSourceTest.csv")

    @DisplayName("Проверка формы обратного звонка CsvFile")
    @Tag("CsvFile")
    void fillFormWithCsvFileSourceTest(String firstName, String userNumber, String currentAddress) {
        open("https://uniofweb.ru/");

        $(".callback-wrapper").click();
        $("[name=form_text_8]").setValue(firstName).pressEnter();
        $("[name=form_text_9]").setValue(userNumber).pressEnter();
        $("[name=form_textarea_10]").setValue(currentAddress).pressEnter();
        $(".submit-wrapper").click();

        $(".form-note").shouldHave(text("Спасибо! Ваша заявка"));
    }



    @ParameterizedTest
@EnumSource(Language.class)

void linguaShouldDisplayCorrectText(Language language) {
    open("https://lingua.com/fr/");
    $(".versionright").$(byText(language.name())).click();
    $("h1").shouldHave(text(language.description));
}
}



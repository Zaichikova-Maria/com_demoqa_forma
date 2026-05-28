import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import testData.data.Language;
import tests.TestBase;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ParameterizeTests extends TestBase {


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
    @DisplayName("Проверка заголовка H1 EnumSource")
    @EnumSource(Language.class)

void linguaShouldDisplayCorrectText(Language language) {
    open("https://lingua.com/");
    $(".versionright").$(byText(language.name())).click();
    $("h1").shouldHave(text(language.description));
}

static Stream<Arguments> linguaShouldDisplayCorrectLanguage() {
        return Stream.of(
                Arguments.of(Language.EN, List.of("That's Lingua", "Reading and Understanding of Texts", "Learn Vocabulary", "Grammar exercises") ),
                Arguments.of(Language.FR, List.of("C'est ça Lingua", "Lecture et compréhension de textes", "Acquisition de vocabulaire", "Exercices") ),
                Arguments.of(Language.IT, List.of("Questo è Lingua.com", "Lettura e comprensione dei testi", "Impara il vocabolario", "Esercizi") )
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("Проверка заголовков H2 MethodSource")

    void linguaShouldDisplayCorrectLanguage(Language language, List<String> learnLanguage) {
        open("https://lingua.com/fr/");
        $(".versionright").$(byText(language.name())).click();
        $$("h2").shouldHave(texts(learnLanguage));
    }


}



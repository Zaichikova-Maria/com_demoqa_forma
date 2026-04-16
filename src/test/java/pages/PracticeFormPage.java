package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;


public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    //Elements
  private SelenideElement firstNameInput = $("#firstName");
  private SelenideElement lastNameInput = $("#lastName");
  private SelenideElement userEmailInput = $("#userEmail");
  private SelenideElement userNumberInput = $("#userNumber");
  private SelenideElement currentAddressInput = $("#currentAddress");
  private SelenideElement genterWrapper = $("#genterWrapper");
  private SelenideElement stateSelect = $("#state");
  private SelenideElement citySelect = $("#city");
  private SelenideElement stateCityContainer = $("#stateCity-wrapper");
  private SelenideElement submitButton = $("#submit");
  private SelenideElement tableResults = $(".table-responsive");
  private SelenideElement subjectsInput = $("#subjectsInput");
  private SelenideElement hobbiesInput = $("#hobbiesWrapper");
  private SelenideElement fotoUpload= $("#uploadPicture");
  private final SelenideElement calendarInput = $("#dateOfBirthInput");




    //Action

    public PracticeFormPage typeHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typeFoto(String value) {
        fotoUpload.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage openPage() {
        open(" ");
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);

        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        return this;
    }

    public PracticeFormPage tableForm(){
        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        return this;
    }


    public PracticeFormPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeLastName(String value) {
            lastNameInput.setValue(value);

            return this;
    }

    public PracticeFormPage typeEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeGenter(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();

        return this;
    }


    public PracticeFormPage setDayOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day,month,year);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCityAndState(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }


    public PracticeFormPage checkResult(String key, String value) {
    resultsTableComponent.checkResult(key, value);

    return this;
    }

    public PracticeFormPage propertyName() {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    public PracticeFormPage propertyLastname() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    public PracticeFormPage propertyNumber() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    public PracticeFormPage propertyGenter() {
        genterWrapper.$(byText("Male")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
}
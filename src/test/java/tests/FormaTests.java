package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.TestData.*;

public class FormaTests extends TestBase {

    @Test
    void successfullFormaTest() {

        practiceFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .typeNumber(userNumber)
                .typeAddress(currentAddress)
                .typeGenter(gender)
                .setCityAndState(state,city)
                .setDayOfBirth(day,month,year)
                .typeSubjects(subject)
                .typeHobbies(hobby)
                .typeFoto(photo)
                .submitForm();

// Проверка формы

        practiceFormPage
                .tableForm()
                .checkResult("Student Name", firstName+ " " +lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Mobile",userNumber)
                .checkResult("Address",currentAddress)
                .checkResult("Hobbies",hobby)
                .checkResult("Gender",gender)
                .checkResult("Subjects",subject)
                .checkResult("State and City",state+ " " +city)
                .checkResult("Picture","foto.jpg")
                .checkResult("Date of Birth",day + " " + month + "," + year);

    }

        @Test
        void negativeFormaTest() {
            practiceFormPage
                    .openPage()
                    .submitForm();

//            проверка
            practiceFormPage
                    .propertyName()
                    .propertyLastname()
                    .propertyNumber()
                    .propertyGenter();


}
}

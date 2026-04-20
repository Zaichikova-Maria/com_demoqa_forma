package tests;

import org.junit.jupiter.api.Test;
import testData.TestData;

import static testData.TestData.*;

public class FormaTests extends TestBase {

    @Test
    void successfullFormaTest() {

        TestData testData  = new TestData();

        practiceFormPage
                .openPage()
                .javaScript()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.userEmail)
                .typeNumber(testData.userNumber)
                .typeAddress(testData.currentAddress)
                .typeGenter(testData.gender)
                .setCityAndState(testData.state,testData.city)
                .setDayOfBirth(testData.day,testData.month,testData.year)
                .typeSubjects(testData.subject)
                .typeHobbies(testData.hobby)
                .typeFoto(testData.photo)
                .submitForm();

// Проверка формы

        practiceFormPage
                .tableForm()
                .checkResult("Student Name", testData.firstName+ " " +testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Mobile",testData.userNumber)
                .checkResult("Address",testData.currentAddress)
                .checkResult("Hobbies",testData.hobby)
                .checkResult("Gender",testData.gender)
                .checkResult("Subjects",testData.subject)
                .checkResult("State and City",testData.state+ " " +testData.city)
                .checkResult("Picture","foto.jpg")
                .checkResult("Date of Birth",testData.day + " " + testData.month + "," + testData.year);

    }

        @Test
        void negativeFormaTest() {
            practiceFormPage
                    .openPage()
                    .javaScript()
                    .submitForm();

//            проверка
            practiceFormPage
                    .propertyName()
                    .propertyLastname()
                    .propertyNumber()
                    .propertyGenter();


}
}

package tests;

import org.junit.jupiter.api.Test;

import static testData.TestData.*;

public class FormaTests extends TestBase {

    @Test
    void successfullFormaTest() {

        practiceFormPage
                .openPage()
                .javaScript()
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

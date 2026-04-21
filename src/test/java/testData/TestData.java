package testData;

import com.github.javafaker.Faker;


public class TestData {
    static Faker faker = new Faker();


// Значения с faker
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().fullAddress();;
    public String gender = faker.options().option("Male", "Female", "Other");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String photo = faker.options().option("foto.jpg", "foto2.jpg");
    public String state = faker.options().option("NCR","Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);
    public String subject = faker.options().option("Math","Music", "Geography", "English");
    public String month = faker.options().option("January","February","March","April","May","June","July","August","September","October","November","December");
    public String year = String.valueOf(faker.number().numberBetween(1920,2024));
    public String day = String.format("%02d",faker.number().numberBetween(1,28));
    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Meerut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> faker.options().option("Jaipur", "Jaisalmer"); // для остальных случаев
        };
    }


    //Значения вручную
        //    public static String firstName = "Maria";
        //    public static String lastName = "Zaychikova";
        //    public static String userEmail = "zaychikova@mail.com";
        //    public static String userNumber = "8123456789";
        //    public static String currentAddress = "adress";
        //    public static String gender = "Female";
        //    public static String hobby = "Music";
        //    public static String photo = "foto.jpg";
        //    public static String state = "NCR";
        //    public static String city = "Noida";
        //    public static String subject = "Math";
        //    public static String day = "01";
        //    public static String month = "May";
        //    public static String year = "1988";

}

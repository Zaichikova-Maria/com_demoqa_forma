package testData;

import com.github.javafaker.Faker;
import Utils.RandomUtils;
import java.util.Locale;

import static Utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker();
    //Faker fakerRu = new Faker(new Locale("ru"));
    RandomUtils randomUtils = new RandomUtils();



    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().fullAddress();;
    public String gender = randomUtils.getRandomGender();
    public String hobby = randomUtils.getRandomHobbies();
    public String photo = randomUtils.getRandomPhoto();
    public String state = randomUtils.getRandomState();
    public String city = getRandomCity(state);
    public String subject = getSubject();
    public String month = getMonth ();
    public int
            year = faker.number().numberBetween(1991, 2099),
            day = faker.number().numberBetween(1,28);


    //public static String firstName = "Maria";
//    public static String lastName = "Zaychikova";
//    public static String userEmail = "zaychikova@mail.com";
//    public static String userNumber = "8123456789";
//    public static String currentAddress = "adress";
//    public static String gender = "Female";
//    public static String hobby = "Music";
//    public static String photo = "img/foto.jpg";
//    public static String state = "NCR";
//    public static String city = "Noida";
//    public static String subject = "Math";
//    public static String day = "01";
//    public static String month = "May";
//    public static String year = "1988";




}

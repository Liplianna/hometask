package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Practice {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void happyTest(){
        String name = "Anna";
        String Lastname = "Liplianin";
        String email = "anna.liplianin@mail.ru";
        String Number = "2912345561";
        String currentAddress = "Vilnius 123";



        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue(name);
        $("[id=lastName]").setValue(Lastname);
        $("[id=userEmail]").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue(Number);
        $("[id= dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("December");
        $("[aria-label = 'Choose Friday, December 23rd, 1994']").click();
        $("#subjectsInput").sendKeys("Computer Science");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").sendKeys("C:\\AUTO\\first_auto\\homework\\resources\\images\\V.jpg");
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
        $("[id=react-select-4-input]").setValue("Lucknow").pressEnter();
        $("[id=submit]").click();

        $(".table-responsive").shouldHave(
                        text(name),
                        text(Lastname),
                        text(email),
                        text("Female"),
                        text(Number),
                        text("23 December,1994"),
                        text("Computer Science"),
                        text("Sports"),
                        text("V.jpg"),
                        text(currentAddress),
                        text("Uttar Pradesh Lucknow"));

        System.out.println("Happy Pass");
    }


    }


package com.ezopikhinaelena.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.ezopikhinaelena.tests.TestData.firstName;
import static com.ezopikhinaelena.tests.TestData.lastName;

public class TextBoxTests extends TestBase{

        @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("mail@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("photo/ce30ff722e5ec13b8e3fc8eb1d2ffcac.jpeg");
        $("#currentAddress").setValue("Street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressTab();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Elena Bulochkina"));
        $(".table-responsive").shouldHave(text("mail@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9999999999"));
        $(".table-responsive").shouldHave(text("02 September,1986"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Computer Science"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("ce30ff722e5ec13b8e3fc8eb1d2ffcac.jpeg"));
        $(".table-responsive").shouldHave(text("Street 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave((text(firstName + " " + lastName)));
    }
}

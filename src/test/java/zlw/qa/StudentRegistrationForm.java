package zlw.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll(){
        //Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;

    }

    @Test
    void fillStudentRegistrationForm(){
        open("https://demoqa.com/automation-practice-form");

        //Ввод данных в поля Name
        $("[id=\"firstName\"]").setValue("Vasilii");
        $("[id=\"lastName\"]").setValue("Shalunov");

        //Ввод данных в поле Email
        $("[id=\"userEmail\"]").setValue("asdori95@gmail.com");

        //Выбор Gender - Male
        $("[for=\"gender-radio-1\"]").click();

        //Ввод телефона пользователя
        $("[id=\"userNumber\"]").setValue("9277779143");

        //Выбор даты рождения пользователя
        $("[id=\"dateOfBirthInput\"]").click();
        $("[class=\"react-datepicker__year-select\"]").$("[value=\"1997\"]").click();
        $("[class=\"react-datepicker__month-select\"]").$("[value=\"6\"]").click();
        $("[class=\"react-datepicker__day react-datepicker__day--029\"]").click();

        //Заполнение поля-автозаполнения Subjects
        $("[class=\"subjects-auto-complete__input\"]").$("[id=\"subjectsInput\"]")
                .setValue("computer science").pressEnter();

        //Выбор Hobbies - Reading
        $("[for=\"hobbies-checkbox-2\"]").click();

        //Загрузка фотографии пользователя
        $("[id=\"uploadPicture\"]").uploadFile
                (new File("src/test/resources/z.jpg"));

        //Скролл страницы к кнопке Sumbit
        $("[id=\"submit\"]").scrollIntoView(true);

        //Заполнение поля Current Address
        $("[id=\"currentAddress\"]").setValue("st. 22 Party Congress, 42, Samara, Samara region, 443066");

        //Выбор State и City
        $("[id=\"react-select-3-input\"]").setValue("haryana").pressEnter();
        $("[id=\"react-select-4-input\"]").setValue("panipat").pressEnter();

        //Регистрация по кнопке Sumbit
        $("[id=\"submit\"]").click();

        //Проверки

        //Проверяем название модального окна
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Проверяем содержание модального окна
        $("[class=\"table table-dark table-striped table-bordered table-hover\"]").$("tbody")
                .shouldHave(text("Vasilii Shalunov"))
                .shouldHave(text("asdori95@gmail.com"))
                .shouldHave(text("Male"))
                .shouldHave(text("9277779143"))
                .shouldHave(text("29 July,1997"))
                .shouldHave(text("Computer Science"))
                .shouldHave(text("Reading"))
                .shouldHave(text("z.jpg"))
                .shouldHave(text("st. 22 Party Congress, 42, Samara, Samara region, 443066"))
                .shouldHave(text("Haryana Panipat"));

    }
}

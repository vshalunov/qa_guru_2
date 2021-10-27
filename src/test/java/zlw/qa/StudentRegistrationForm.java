package zlw.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
                (new File("C:\\Users\\Vasily\\Pictures\\bugs-bunny-communist-1.jpg"));

        //Скролл страницы к кнопке Sumbit
        $("[id=\"submit\"]").scrollIntoView(true);

        //Заполнение поля Current Address
        $("[id=\"currentAddress\"]").setValue("22 Партсъезда, 42\n" +
                "\u200BСоветский район, Самара \u200B443066");

        //Выбор State и City
        $("[id=\"react-select-3-input\"]").setValue("haryana").pressEnter();
        $("[id=\"react-select-4-input\"]").setValue("panipat").pressEnter();

        //Регистрация по кнопке Sumbit
        $("[id=\"submit\"]").click();

        //for debug
        $("[id=\"gender-radio-1\"]").click();

    }
}

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
        $("[class=\"modal-title h4\"]").shouldHave(text("Thanks for submitting the form"));

        //Проверяем содержание модального окна
        $x("//div[@class=\"table-responsive\"]//tr[1]/td[2]").shouldHave(text("Vasilii Shalunov"));
        $x("//div[@class=\"table-responsive\"]//tr[2]/td[2]").shouldHave(text("asdori95@gmail.com"));
        $x("//div[@class=\"table-responsive\"]//tr[3]/td[2]").shouldHave(text("Male"));
        $x("//div[@class=\"table-responsive\"]//tr[4]/td[2]").shouldHave(text("9277779143"));
        $x("//div[@class=\"table-responsive\"]//tr[5]/td[2]").shouldHave(text("29 July,1997"));
        $x("//div[@class=\"table-responsive\"]//tr[6]/td[2]").shouldHave(text("Computer Science"));
        $x("//div[@class=\"table-responsive\"]//tr[7]/td[2]").shouldHave(text("Reading"));
        $x("//div[@class=\"table-responsive\"]//tr[8]/td[2]").shouldHave(text("z.jpg"));
        $x("//div[@class=\"table-responsive\"]//tr[9]/td[2]")
                .shouldHave(text("st. 22 Party Congress, 42, Samara, Samara region, 443066"));
        $x("//div[@class=\"table-responsive\"]//tr[10]/td[2]").shouldHave(text("Haryana Panipat"));

    }
}

package zlw.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    }
}

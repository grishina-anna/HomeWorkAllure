package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.EventListener;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide()); //подключается аллюр отчет, если аллюр не работал раньше
        open("https://github.com");
        $(".header-search-input").click();  //делаем окно поиска в фокусе
        $(".header-search-input").sendKeys("eroshenkoam/allure-example"); //вводим поиск
        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click(); //переходим на страницу результата поиска
        $(By.partialLinkText("Issues")).click(); //ищем по частичному совпадению
        $(withText("#5788")).should(Condition.visible);

    }

}

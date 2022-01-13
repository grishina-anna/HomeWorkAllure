package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        open("https://github.com");
        $(".header-search-input").click();  //делаем окно поиска в фокусе
        $(".header-search-input").sendKeys("eroshenkoam/allure-example"); //вводим поиск
        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click(); //переходим на страницу результата поиска
        $(By.partialLinkText("Issues")).click(); //ищем по частичному совпадению
        $(withText("#681")).should(Condition.visible);

    }

}

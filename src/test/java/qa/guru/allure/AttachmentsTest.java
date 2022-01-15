package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 57;

    @Test
    public void lambdaAttachmentTests() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();  //делаем окно поиска в фокусе
            $(".header-search-input").sendKeys(REPOSITORY); //вводим поиск
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click(); //переходим на страницу результата поиска
        });
        step("Открываем tab Issues", () -> {
            Allure.addAttachment("Page Source", "text/html",WebDriverRunner.source(), "html");
            $(By.partialLinkText("Issues")).click(); //ищем по частичному совпадению
        });
        step("Проверяем наличие Issues с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssuesWithNumber(NUMBER);
    }
}

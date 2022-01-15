package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage (){
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void openRepositoryPage(String repository){
        $(By.linkText("eroshenkoam/allure-example")).click();
    }

    @Step("Открываем tab Issues")
    public void openIssuesTab(){
        attachPageSource();
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем наличие Issues с номером {number}")
    public void shouldSeeIssuesWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenhot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

//    @Test
//    public void annotatedStepsTest() {
//        WebSteps steps = new WebSteps();
//        steps.openMainPage();
//        steps.searchForRepository();
//        steps.openRepositoryPage();
//        steps.openIssuesTab();
//        steps.shouldSeeIssuesWithNumber();
//
//    }
}


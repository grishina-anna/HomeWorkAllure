package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTests {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 57;

    @Test
    public void lambdaLabelsTests() {
            }

            //описание через аннотацию
    @Test
    @Owner("eroshenkoam") //ответсвенный за тест
    @Feature("Issues") //название фичи
    @Stories({
            @Story("Создание Issues для авторизованного пользователя"), //формулируется требование к функциональности, которое должно быть выполнено
            @Story("Создание Issues со страницы репозитория")
    })
    @DisplayName("Создание Issues для авторизованного пользователя")
    @Severity(SeverityLevel.BLOCKER) //уровень критичности
    @Link(value = "Github", url = "http://github.com")

    public void annotatedLabelsTest() {
           }
}

package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;


public class ParametrsTests {

    @Test
    public void lambdaLabelsTests() {
        Allure.parameter("Регион", "Москва"); //указываются входные параметры
        Allure.parameter("Область", "Московская"); //отображаются на вкладке Suites
            }
}

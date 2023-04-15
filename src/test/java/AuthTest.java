import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class AuthTest {

    @Test
    void correctLoginTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL).password(Utils.CORRECT_PASSWORD);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void incorrectLoginTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                String error = authPage.authWithIncorrectLogin(Utils.INCORRECT_EMAIL);
                assertEquals("Не удалось найти аккаунт Google.", error);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void incorrectPasswordTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                String error = authPage.login(Utils.CORRECT_EMAIL).authWithIncorrectPassword(Utils.WRONG_PASSWORD);
                assertEquals("Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.", error);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        drivers.forEach(WebDriver::quit);
    }
}

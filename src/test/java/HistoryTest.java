import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HistoryTest {

    @AfterEach
    public void tearDown() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void clearHistoryTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL)
                        .password(Utils.CORRECT_PASSWORD)
                        .burgerMenu()
                        .deleteAllHistory();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

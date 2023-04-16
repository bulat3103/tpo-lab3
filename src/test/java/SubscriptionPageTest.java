import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionPageTest {

    @AfterEach
    public void tearDown() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void changeAlarmTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL)
                        .password(Utils.CORRECT_PASSWORD)
                        .manageSubscriptions()
                        .changeAlarms();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

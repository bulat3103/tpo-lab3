import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LikedVideoPageTest {
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
                        .likesMenu()
                        .deleteLiked();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

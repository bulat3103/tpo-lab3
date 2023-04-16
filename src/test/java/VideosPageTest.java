import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class VideosPageTest {

    @AfterEach
    public void tearDown() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void checkSearchTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            MainPage mainPage = new MainPage();
            mainPage.createQuery(Utils.QUERY);
        });
    }

    @Test
    public void profileNameTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                String profileName = authPage.login(Utils.CORRECT_EMAIL).password(Utils.CORRECT_PASSWORD).getProfileName();
                assertEquals("Itmo Tpo", profileName, "Имена должны совпадать");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void likeTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL)
                        .password(Utils.CORRECT_PASSWORD)
                        .likeVideo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void subscribeTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL)
                        .password(Utils.CORRECT_PASSWORD)
                        .subscribeToChannel();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void goToShortsTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL)
                        .password(Utils.CORRECT_PASSWORD)
                        .goToShorts();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void playAllVideoTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            Page.setDriver(driver);
            AuthPage authPage = new AuthPage();
            try {
                authPage.login(Utils.CORRECT_EMAIL)
                        .password(Utils.CORRECT_PASSWORD)
                        .playAllVideoOnChannel();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

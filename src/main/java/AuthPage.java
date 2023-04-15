import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends Page{
    @FindBy(xpath = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[3]/div[2]/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]")
    private WebElement loginButton;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")
    private WebElement loginInput;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
    private WebElement errorsField;

    public AuthPage() {
        driver.get(Utils.BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public PasswordPage login(String login) throws InterruptedException {
        loginButton.click();
        Thread.sleep(1000);
        loginInput.sendKeys(login, Keys.ENTER);
        return new PasswordPage();
    }

    public String authWithIncorrectLogin(String login) throws InterruptedException {
        loginButton.click();
        Thread.sleep(1000);
        loginInput.sendKeys(login, Keys.ENTER);
        return errorsField.getText();
    }
}

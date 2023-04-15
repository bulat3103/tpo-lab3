import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends Page{
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")
    private WebElement passwordButton;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]")
    private WebElement errorsField;
    public PasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public VideosPage password(String password) {
        passwordButton.sendKeys(password, Keys.ENTER);
        return new VideosPage();
    }

    public String authWithIncorrectPassword(String login) {
        passwordButton.sendKeys(login, Keys.ENTER);
        return errorsField.getText();
    }

}

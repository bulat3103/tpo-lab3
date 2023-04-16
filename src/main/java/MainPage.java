import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {
    @FindBy(xpath = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")
    private WebElement searchInput;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/button")
    private WebElement searchSubmit;

    public MainPage() {
        driver.get("https://www.youtube.com/");
        PageFactory.initElements(driver, this);
    }

    public MainPage createQuery(String query) {
        searchInput.sendKeys(query);
        searchSubmit.click();
        return this;
    }
}

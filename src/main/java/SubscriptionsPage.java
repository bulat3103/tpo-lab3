import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionsPage extends Page{
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-shelf-renderer/div[1]/div[2]/ytd-expanded-shelf-contents-renderer/div/ytd-channel-renderer[1]/div/div[2]/div[1]/div[2]/ytd-subscribe-button-renderer/div[2]/ytd-subscription-notification-toggle-button-renderer-next/yt-button-shape/button")
    private WebElement changeAlarmsButton;
    @FindBy(xpath = "/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-service-item-renderer[1]/tp-yt-paper-item")
    private WebElement chooseAllAlarmsButton;

    public SubscriptionsPage() {
        PageFactory.initElements(driver, this);
    }

    public SubscriptionsPage changeAlarms() throws InterruptedException {
        changeAlarmsButton.click();
        chooseAllAlarmsButton.click();
        return this;
    }
}

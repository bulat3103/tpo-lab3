import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage extends Page{
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[2]/ytd-browse-feed-actions-renderer/div/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div")
    private WebElement clearHistory;
    @FindBy(xpath = "/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/yt-confirm-dialog-renderer/div[2]/div[2]/yt-button-renderer[3]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement confirmClear;

    public HistoryPage() {
        PageFactory.initElements(driver, this);
    }

    public HistoryPage deleteAllHistory() {
        clearHistory.click();
        confirmClear.click();
        return this;
    }
}

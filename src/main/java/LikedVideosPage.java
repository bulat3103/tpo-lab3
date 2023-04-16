import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LikedVideosPage extends Page {
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-playlist-video-list-renderer/div[3]/ytd-playlist-video-renderer/div[3]/ytd-menu-renderer/yt-icon-button/button")
    private WebElement actionsButton;
    @FindBy(xpath = "/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-service-item-renderer[5]/tp-yt-paper-item")
    private WebElement deleteButton;

    public LikedVideosPage() {
        PageFactory.initElements(driver, this);
    }

    public LikedVideosPage deleteLiked() {
        actionsButton.click();
        deleteButton.click();
        return this;
    }
}

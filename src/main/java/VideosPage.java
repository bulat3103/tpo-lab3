import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideosPage extends Page{
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[6]/ytd-rich-grid-row[1]/div/ytd-rich-item-renderer[1]/div/ytd-rich-grid-media/div[1]/div[2]/div[1]/h3/a")
    private WebElement firstYoutubeVideoLink;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-watch-metadata/div/div[2]/div[2]/div/div/ytd-menu-renderer/div[1]/ytd-segmented-like-dislike-button-renderer/div[1]/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement likeButton;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-watch-metadata/div/div[2]/div[1]/div/ytd-subscribe-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement subscribeButton;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[3]/div[2]/ytd-topbar-menu-button-renderer[2]/button/yt-img-shadow/img")
    private WebElement profileButton;
    @FindBy(xpath = "/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-multi-page-menu-renderer/div[2]/ytd-active-account-header-renderer/div/yt-formatted-string[1]")
    private WebElement profileName;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[2]")
    private WebElement shortsButton;
    @FindBy(xpath = "/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-multi-page-menu-renderer/div[3]/div[1]/yt-multi-page-menu-section-renderer[1]/div[2]/ytd-compact-link-renderer[4]/a/tp-yt-paper-item/div[2]")
    private WebElement logoutButton;

    public VideosPage() {
        PageFactory.initElements(driver, this);
    }


    public VideosPage likeVideo() throws InterruptedException {
        firstYoutubeVideoLink.click();
        likeButton.click();
        return this;
    }

    public VideosPage subscribeToChannel() throws InterruptedException {
        firstYoutubeVideoLink.click();
        subscribeButton.click();
        return this;
    }

    public VideosPage goToShorts() throws InterruptedException {
        shortsButton.click();
        return this;
    }

    public String getProfileName() throws InterruptedException {
        profileButton.click();
        return profileName.getText();
    }

    public MainPage logout() throws InterruptedException {
        profileButton.click();
        logoutButton.click();
        return new MainPage();
    }
}

package com.spotify.testing.pageobjects;

import com.spotify.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "https://www.spotify.com/hu/";

    @FindBy(css = "header li:nth-child(5) > a")
    private WebElement registrationButton;

    @FindBy(css = "header li:nth-child(1) > a")
    private WebElement premiumButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieDisclaimer;

    public HomePage(final WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage() {
        navigateToUrl(HOME_PAGE_URL);
    }

    public void clickOnRegistrationButton() {
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
        waitForPageReadiness();
    }

    public void clickOnCookieDisclaimer() {
        waitForElementToBeClickable(cookieDisclaimer);
        clickWithJsExecutor(cookieDisclaimer);
    }

    public void clickOnPremiumButton() {
        waitForElementToBeClickable(premiumButton);
        premiumButton.click();
        waitForPageReadiness();
    }
}

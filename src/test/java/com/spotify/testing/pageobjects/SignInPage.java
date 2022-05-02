package com.spotify.testing.pageobjects;


import com.spotify.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignInPage extends CommonPageObject {

    private static final String MAIN_PAGE_URL = "https://open.spotify.com/";

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "login-username")
    private WebElement loginUsername;

    @FindBy(id = "login-password")
    private WebElement loginPassword;

    public void navigateToMainPage() {
        navigateToUrl(MAIN_PAGE_URL);
    }

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Email address or username", loginUsername,
            "Password", loginPassword

    );

    public SignInPage(final WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnLoginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        waitForPageReadiness();
    }


    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}

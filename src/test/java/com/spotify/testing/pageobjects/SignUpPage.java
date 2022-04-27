package com.spotify.testing.pageobjects;

import com.spotify.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignUpPage extends CommonPageObject {

    @FindBy(css = ".EmailForm__Center-jwtojv-0 > div")
    private WebElement registrationButton;

    @FindBy(id = "month")
    private WebElement selectMonth;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "confirm")
    private WebElement confirmEmailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "displayname")
    private WebElement displaynameInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(id = "day")
    private WebElement dayInput;

    @FindBy(how = How.CSS, using = "div.Radio-tr5kfi-0")
    private WebElement genderOption;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Elfogadom a')]")
    private WebElement acceptTerms;

    @FindBy(id = "checkbox-container")
    private WebElement notRobot;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
        "Enter your email.", emailInput,
        "Enter your email again.", confirmEmailInput,
        "Create password.", passwordInput,
        "Enter a profile name.", displaynameInput,
        "YYYY", yearInput,
        "Month", selectMonth,
        "DD", dayInput
    );

    public SignUpPage(final WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnRegistrationButton() {
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
        waitForPageReadiness();
    }

    public void  clickOnSelectMonth() {
        selectMonth.click();
        waitForPageReadiness();
    }

    public void clickOnGenderOptionMale() {
        genderOption.click();
        waitForPageReadiness();
    }

    public void clickOnAcceptTerms() {
        acceptTerms.click();
        waitForPageReadiness();
    }

    public void clickOnNotRobot() {
        notRobot.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}

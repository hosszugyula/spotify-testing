package com.spotify.testing.pageobjects;

import com.spotify.testing.factory.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class PremiumPage extends CommonPageObject {

    private static final String PREMIUM_PAGE_URL = "https://www.spotify.com/hu/premium";
    private static final String PREMIUM_PLANS_PAGE_URL = "https://www.spotify.com/hu/premium/#plans";
    private static final String GET_STARTED_INDIVIDUAL_URL = "https://www.spotify.com/purchase/offer/2022-midyear-trial-3m?marketing-campaign-id=default&country=HU";
    private static final String GET_STARTED_DUO_URL = "https://www.spotify.com/hu/purchase/offer/duo-1-month-trial?country=HU";
    private static final String GET_STARTED_FAMILY_URL = "https://www.spotify.com/hu/purchase/offer/new-family-1m?country=HU";
    private static final String GET_STARTED_STUDENT_URL = "https://www.spotify.com/hu/student/verification";

    private String scrollElementIntoMiddle =
            "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

    @FindBy(xpath = "//div[contains(@class, 'ButtonInner-sc-14ud5tc-0 fQivni sc-jrsJWt gNCnmw sc-kEqXSa fTvsDS')]")
    private WebElement viewPlansButton;

    @FindBy(xpath = "//a[contains(@href, 'https://www.spotify.com/purchase/offer/2022-midyear-trial-3m?marketing-campaign-id=default&country=HU') and contains(@class, 'Button-qlcn5g-0 hZbPoZ')]")
    private WebElement getStartedButtonIndividual;

    @FindBy(xpath = "//*[contains(@href, '/hu/purchase/offer/duo-1-month-trial?country=HU') and contains(@class, 'Button-qlcn5g-0 hZbPoZ')]")
    private WebElement getStartedButtonDuo;

    @FindBy(xpath = "//*[contains(@href, '/hu/purchase/offer/new-family-1m?country=HU') and contains(@class, 'Button-qlcn5g-0 hZbPoZ')]")
    private WebElement getStartedButtonFamily;

    @FindBy(xpath = "//*[contains(@href, '/hu/student/verification') and contains(@class, 'Button-qlcn5g-0 hZbPoZ')]")
    private WebElement getStartedButtonStudent;

    @FindBy(xpath = "//div[contains(@class, 'ButtonInner-sc-14ud5tc-0 eUyfdq sc-jrsJWt gNCnmw sc-kEqXSa exRBIa')]")
    private WebElement get3MonthsFreeButton;


    public PremiumPage(final WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToPremiumPage() {
        navigateToUrl(PREMIUM_PAGE_URL);
    }

    public void navigateToGetStartedIndividualPage() {
        navigateToUrl(GET_STARTED_INDIVIDUAL_URL);
    }

    public void navigateToGetStartedDuoPage() {
        navigateToUrl(GET_STARTED_DUO_URL);
    }

    public void navigateToGetStartedFamilyPage() {
        navigateToUrl(GET_STARTED_FAMILY_URL);
    }

    public void navigateToGetStartedStudentPage() {
        navigateToUrl(GET_STARTED_STUDENT_URL);
    }

    public void scrollToThePlans() {
        navigateToUrl(PREMIUM_PLANS_PAGE_URL);
    }

    private void clickOnElement(WebElement element) {
        ((JavascriptExecutor) getWebDriverFromFactory()).executeScript("arguments[0].click()", element);
    }

    public void clickOnGetStartedIndividualButton() {
        scrollToPlan(getStartedButtonIndividual);
        waitForElementToBeClickable(getStartedButtonIndividual);
        clickOnElement(getStartedButtonIndividual);
        waitForPageReadiness();
    }

    public void clickOnGetStartedDuoButton() {
        scrollToPlan(getStartedButtonDuo);
        waitForElementToBeClickable(getStartedButtonDuo);
        clickOnElement(getStartedButtonDuo);
        waitForPageReadiness();
    }

    public void clickOnGetStartedFamilyButton() {
        scrollToPlan(getStartedButtonFamily);
        waitForElementToBeClickable(getStartedButtonFamily);
        clickOnElement(getStartedButtonFamily);
        waitForPageReadiness();
    }

    public void clickOnGetStartedStudentButton() {
        scrollToPlan(getStartedButtonStudent);
        waitForElementToBeClickable(getStartedButtonStudent);
        clickOnElement(getStartedButtonStudent);
        waitForPageReadiness();
    }

    private void scrollToPlan(WebElement element) {
        ((JavascriptExecutor) getWebDriverFromFactory()).executeScript(scrollElementIntoMiddle, element);
    }

    public void clickOn3MonthsFreeButton() {
        waitForElementToBeClickable(get3MonthsFreeButton);
        get3MonthsFreeButton.click();
        waitForPageReadiness();
    }

    public void clickOnGetStartedButton(final String plan) throws Exception {
        switch (plan) {
            case "Individual":
                clickOnGetStartedIndividualButton();
                break;

            case "Duo":
                clickOnGetStartedDuoButton();
                break;

            case "Family":
                clickOnGetStartedFamilyButton();
                break;

            case "Student":
                clickOnGetStartedStudentButton();
                break;
        }
    }

    public void navigateToAuthenticationContinuingToPlan(final String plan) {
        switch (plan) {
            case "Individual":
                navigateToGetStartedIndividualPage();
                break;

            case "Duo":
                navigateToGetStartedDuoPage();
                break;

            case "Family":
                navigateToGetStartedFamilyPage();
                break;

            case "Student":
                navigateToGetStartedStudentPage();
                break;
        }
    }

    public void clickOnViewPlansButton() {
        viewPlansButton.click();
        waitForPageReadiness();
    }


}

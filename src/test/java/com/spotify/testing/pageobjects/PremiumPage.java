package com.spotify.testing.pageobjects;

import com.spotify.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class PremiumPage extends CommonPageObject {

    private static final String PREMIUM_PAGE_URL = "https://www.spotify.com/hu/premium";
    private static final String PREMIUM_PLANS_PAGE_URL = "https://www.spotify.com/hu/premium/#plans";
    private static final String GET_STARTED_INDIVIDUAL_URL = "https://www.spotify.com/purchase/offer/2022-midyear-trial-3m?marketing-campaign-id=default&country=HU";
    private static final String GET_STARTED_DUO_URL = "https://www.spotify.com/hu/purchase/offer/duo-1-month-trial?country=HU";
    private static final String GET_STARTED_FAMILY_URL = "https://www.spotify.com/hu/purchase/offer/new-family-1m?country=HU";
    private static final String GET_STARTED_STUDENT_URL = "https://www.spotify.com/hu/student/verification";


    @FindBy(css = "div[class$='ButtonInner-sc-14ud5tc-0 fQivni sc-jrsJWt gNCnmw sc-kEqXSa fTvsDS']")
    private WebElement viewPlansButton;

    @FindBy(css = "div[data-event-offer-type-id$='trial-3m']")
    private WebElement getStartedButtonIndividual;

    @FindBy(css = "div[data-event-offer-type-id$='duo-master-trial-1m']")
    private WebElement getStartedButtonDuo;

    @FindBy(css = "div[data-event-offer-type-id$='new-family-master-trial-1m']")
    private WebElement getStartedButtonFamily;

    @FindBy(css = "div[data-event-offer-type-id$='student-trial-1m']")
    private WebElement getStartedButtonStudent;

    @FindBy(css = "div[class$='ButtonInner-sc-14ud5tc-0 eUyfdq sc-jrsJWt gNCnmw sc-kEqXSa exRBIa']")
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

    public void clickOnGetStartedIndividualButton() {
        waitForElementToBeClickable(getStartedButtonIndividual);
        getStartedButtonIndividual.click();
        waitForPageReadiness();
    }

    public void clickOnGetStartedDuoButton() {
        waitForElementToBeClickable(getStartedButtonDuo);
        getStartedButtonDuo.click();
        waitForPageReadiness();
    }

    public void clickOnGetStartedFamilyButton() {
        waitForElementToBeClickable(getStartedButtonFamily);
        getStartedButtonFamily.click();
        waitForPageReadiness();
    }

    public void clickOnGetStartedStudentButton() {
        waitForElementToBeClickable(getStartedButtonStudent);
        getStartedButtonStudent.click();
        waitForPageReadiness();
    }

    public void clickOn3MonthsFreeButton() {
        waitForElementToBeClickable(get3MonthsFreeButton);
        get3MonthsFreeButton.click();
        waitForPageReadiness();
    }

    public void clickOnGetStartedButton(final String plan) {
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

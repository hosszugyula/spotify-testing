package com.spotify.testing.stepdefinitions;

import com.spotify.testing.config.TestConfig;
import com.spotify.testing.pageobjects.HomePage;
import com.spotify.testing.pageobjects.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

import static com.spotify.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class SpotifySignupStepDefs {

    @Autowired
    private HomePage homePage;

    @Autowired
    private SignUpPage signUpPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.navigateToHomePage();
    }

    @And("the Cookie disclaimer is closed")
    public void theCookieDisclaimerIsClosed() {
        homePage.clickOnCookieDisclaimer();
    }

    @And("the Regisztráció header button is clicked")
    public void theRegistrationHeaderButtonIsClicked() {
        homePage.clickOnRegistrationButton();
    }

    @Given("it is scrolled down")
    public void itIsScrolledDown() {
        signUpPage.scrollToTheBottomOfThePage();
    }

    @When("the Regisztráció button is clicked")
    public void theRegistrationButtonIsClicked() {
        signUpPage.clickOnRegistrationButton();
    }

    @And("the month selector is clicked")
    public void theSelectMonthIsClicked() {signUpPage.clickOnSelectMonth(); }

    @And("the male of gender options selected")
    public void theGenderOptionIsClicked() {signUpPage.clickOnGenderOptionMale();}

    @And("the accept the terms and conditions is clicked")
    public void acceptTermsClicked() {signUpPage.clickOnAcceptTerms();}

    @And("the i'm not a robot is clicked")
    public void notRobotClicked() {signUpPage.clickOnNotRobot();}

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> signUpPage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//div[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))
                        ).size(),
                        Matchers.is(0));
    }

    @When("the {string} is filled in with {string}")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        signUpPage.getInputFieldByName(field).sendKeys(content);
    }

    @When("the Tab button is pressed")
    public void theTabButtonIsPressed() {
        new Actions(signUpPage.getWebDriverFromFactory()).sendKeys(Keys.TAB).build().perform();
        signUpPage.waitForPageReadiness();
    }
}

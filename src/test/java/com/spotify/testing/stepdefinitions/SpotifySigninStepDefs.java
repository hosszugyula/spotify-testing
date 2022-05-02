package com.spotify.testing.stepdefinitions;


import com.spotify.testing.config.TestConfig;
import com.spotify.testing.pageobjects.HomePage;
import com.spotify.testing.pageobjects.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

import static com.spotify.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;


@ContextConfiguration(classes = TestConfig.class)
public class SpotifySigninStepDefs {

    @Autowired
    private HomePage homePage;

    @Autowired
    private SignInPage signInPage;


    @And("the Bejelentkezés header button is clicked")
    public void theLoginHeaderButtonIsClicked() {
        homePage.clickOnLoginButton();
    }

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) on the login page should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> signInPage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//div[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))
                        ).size(),
                        Matchers.is(0));
    }

    @When("the Bejelentkezés button is clicked")
    public void theLoginButtonIsClicked() {
        signInPage.clickOnLoginButton();
    }

    @When("the {string} is filled in with {string} in the login form")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        signInPage.getInputFieldByName(field).sendKeys(content);
    }


    @Then("navigate Main page")
    public void goToMain() {
        signInPage.navigateToMainPage();
    }
}

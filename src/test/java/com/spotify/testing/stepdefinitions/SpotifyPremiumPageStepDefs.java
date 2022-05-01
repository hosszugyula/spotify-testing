package com.spotify.testing.stepdefinitions;

import com.spotify.testing.config.TestConfig;
import com.spotify.testing.pageobjects.HomePage;
import com.spotify.testing.pageobjects.PremiumPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = TestConfig.class)
public class SpotifyPremiumPageStepDefs {

    @Autowired
    private HomePage homePage;

    @Autowired
    private PremiumPage premiumPage;


    @And("the Premium header button is clicked")
    public void thePremiumHeaderButtonIsClicked() throws Exception {
        homePage.clickOnPremiumButton();
    }

    @And("the view plans button is clicked")
    public void theViewPlansButtonIsClicked() throws Exception {
        premiumPage.clickOnViewPlansButton();
    }

    @And("the get 3 months free button is clicked")
    public void theGet3MonthsFreeButtonIsClicked() throws Exception {
        premiumPage.clickOn3MonthsFreeButton();
    }

    @Given("the premium page is scrolled to the plans")
    public void thePremiumPageIsScrolledToPlans() throws Exception{
        premiumPage.scrollToThePlans();
    }


    @When("the get started under {string} plan is clicked")
    public void theGetStartedButtonIsClicked(final String plan) throws Exception{
        premiumPage.clickOnGetStartedButton(plan);
    }

    @And("the page is scrolled to the bottom")
    public void thePageIsScrolledToTheBottom() {
        premiumPage.scrollToTheBottomOfThePage();
    }

    @Then("the page is navigated to authentication continuing to {string} plan url")
    public void goToAuthenticationContiuningToPlan(final String plan) {
        premiumPage.navigateToAuthenticationContinuingToPlan(plan);
    }

}

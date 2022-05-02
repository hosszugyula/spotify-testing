package com.spotify.testing.stepdefinitions;


import com.spotify.testing.config.TestConfig;
import com.spotify.testing.pageobjects.HomePage;
import com.spotify.testing.pageobjects.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;



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

    @When("the Bejelentkezés button is clicked")
    public void theLoginButtonIsClicked() {
        signInPage.clickOnLoginButton();
    }


    @Then("navigate Main page")
    public void goToMain() {
        signInPage.navigateToMainPage();
    }
}

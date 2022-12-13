package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import com.herokuapp.utility.Utility;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "username")
    WebElement userNameLink;
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordLink;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement loginSecureText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='flash-messages']")
    WebElement inValidCredentialMessage;

    public void enterUserName(String userNameText) {
        Reporter.log("Enter user name " + userNameLink.getText());
        sendTextToElement(userNameLink, userNameText);
    }

    public void enterPassword(String passwordText) {
        Reporter.log("Enter password  " + passwordLink.getText());
        sendTextToElement(passwordLink, passwordText);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button " + loginButton.getText());
        clickOnElement(loginButton);
    }

    public String loginSucessfulText() {
        Reporter.log("Verify login successful text " + loginSecureText.getText());
        return getTextFromElement(loginSecureText);
    }

    public String inValidUserAndPasswordMessage() {
        Reporter.log("Verify invalid user and password message " + inValidCredentialMessage.getText());
        return getTextFromElement(inValidCredentialMessage).substring(0, 25);
    }

}

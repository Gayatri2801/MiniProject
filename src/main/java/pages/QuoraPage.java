package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class QuoraPage {

    WebDriver driver;

    By searchBox = By.xpath("//input[@placeholder='Search content']");
    By signUpEmail = By.xpath("//div[text()='Sign up with email']");
    By nameField = By.xpath("//input[@placeholder='What would you like to be called?']");
    By emailField = By.xpath("//input[@placeholder='Your email']");
    By signUpButton = By.xpath("//*[@id='root']/div/div[2]/div[1]/div[2]/div/div[2]/div/button");

    public QuoraPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignUpButtonDisabled() {
        return !driver.findElement(signUpButton).isEnabled();
    }

    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        
    }

    public void clickSignUpWithEmail() {
        driver.findElement(signUpEmail).click();
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
}
package co.com.client.webproject.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By dropDownLink = By.linkText("Dropdown");
    private By javaScriptAlertsLink = By.linkText("JavaScript Alerts");
    private By wysiwygEditor = By.linkText("WYSIWYG Editor");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFormAuthentication(){
        driver.findElement(formAuthenticationLink).click();
    }

/*    public DropdownPage clickDropDown(){
        driver.findElement(dropDownLink).click();
        return new DropdownPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        driver.findElement(javaScriptAlertsLink).click();
        return new AlertsPage(driver);
    }

    public WysiwygEditorPage clickwysiwygEditor(){
        driver.findElement(wysiwygEditor).click();
        return new WysiwygEditorPage(driver);
    }*/
}

package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.HomePage;
import co.com.client.webproject.test.page.LoginPage;
import co.com.framework.test.automationtools.selenium.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BusinessController {

    private WebDriver driver;



    public void starApp(String url, String feature, String scenario){
//        Browser browser = new Browser();
//        browser.setBrowser(Browser.Browsers.CHROME);
//        browser.setMaximized(true);
//        browser.setIncognito(true);
//        browser.setDriverVersion("72.0.3626.69");
//        browser.setAutoDriverDownload(true);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions o= new ChromeOptions();
        o.addArguments("--incognito");
        DesiredCapabilities c = DesiredCapabilities.chrome();
        c.setCapability(ChromeOptions.CAPABILITY, o);
        driver = new ChromeDriver(o);
        //driver.get("");
        driver.get(url);
        driver.manage().window().maximize();
        //Provide a handler to the home page, from the framework level -->
        System.out.println(driver.getTitle());


        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickFormAuthentication();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void inputCredentials(String username, String password){
        try {
            LoginPage loginPage= new LoginPage(driver);
            loginPage.setUsernameField(username);
            loginPage.setPasswordField(password);
            loginPage.clickLoginButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

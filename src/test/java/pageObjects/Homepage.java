package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class Homepage extends BasePage{

    public Homepage(WebDriver driver) {
        super(driver);
    }



     @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    WebElement linkAccount;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul/li[1]/a")
     WebElement linkRegister;

    @FindBy(linkText = "Login")
    WebElement linkLogin;







    public void clickmyaccount()
    {

        linkAccount.click();
    }

    public void clickRegister()
    {

        linkRegister.click();
    }


    public void clickLogin()
    {
        linkLogin.click();
    }

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {


    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }



    @FindBy (xpath = "//*[@id='input-firstname']")
    WebElement txtFirstname;

    @FindBy (xpath = "//*[@id='input-lastname']")
    WebElement txtLastname;
    @FindBy (xpath = "//*[@id='input-email']")
    WebElement txtEmail;

    @FindBy (xpath = "//*[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy (xpath = "//*[@id='input-password']")
    WebElement txtPassword;

    @FindBy (xpath  ="//*[@id='input-confirm']")
    WebElement txtConfirmpassword;

    @FindBy (xpath = "//*[@name='agree']")
    WebElement chkPrivacypolicy;


    @FindBy (xpath = "//*[@value='Continue']")
    WebElement btnContinue;


    @FindBy (xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;



    public void setFirstname (String fname)
    {
        txtFirstname.sendKeys(fname);

    }

   public void setLastname(String lname)
   {
       txtLastname.sendKeys(lname);
   }

   public void setEmail(String email)
   {
       txtEmail.sendKeys(email);

   }

   public void settelhephone(String tel)
   {
       txtTelephone.sendKeys(tel);
   }

   public void setPassword(String pwd)
   {
       txtPassword.sendKeys(pwd);
   }


   public  void setTxtConfirmpassword(String pwd)
   {
       txtConfirmpassword.sendKeys(pwd);
   }

   public void setprivacy()
   {
       chkPrivacypolicy.click();
   }


   public void clickcontinue()
   {
       btnContinue.click();
   }


   public  String getconfirmationmsg()
   {
       try {
           return (msgConfirmation.getText());
       } catch (Exception e) {
          return (e.getMessage());
       }
   }




}

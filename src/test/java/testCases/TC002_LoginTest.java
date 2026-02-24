package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {


    @Test(groups={"Sanity","Master"})
public void verify_login()
{
    logger.info("*****Starting TC002_LoginTest *******");

    try {


    //homepage
    Homepage hp = new Homepage(driver);
    hp.clickmyaccount();
    hp.clickLogin();

    //loginpage
    LoginPage lp = new LoginPage(driver);
    lp.setEmail(prop.getProperty("email"));
    lp.setPassword(prop.getProperty("password"));



    lp.clicklogin();

    //My Account page


    MyAccountPage mp = new MyAccountPage(driver);
    boolean target = mp.isMyAccountPageExist();


    Assert.assertTrue(target);
    } catch (Exception e) {
        Assert.fail();
    }


    logger.info("*****Finished TC002_LoginTest *******");

}



}

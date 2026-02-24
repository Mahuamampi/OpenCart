package testCases;


//Data is valid, login success--test pass, logout
//Data is valid, login fail--test fail
//Data is invalid,login success--test fail, logout
//Data is invalid, login fail--test pass


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {







@Test (dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "Datadriven") //getting data provider from different package
    public void verify_DDT(String email, String pwd, String exp)
    {
        try {

            logger.info("***********Starting TC003__LOGIN DDT Test*****");
            Homepage hp = new Homepage(driver);
            hp.clickmyaccount();
            hp.clickLogin();

            //loginpage
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);


            lp.clicklogin();

            //My Account page


            MyAccountPage mp = new MyAccountPage(driver);
            boolean target = mp.isMyAccountPageExist();

            if (exp.equalsIgnoreCase("Valid")) {
                if (target == true) {
                    mp.clicklogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (target == true) {
                    mp.clicklogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
                Assert.fail();
        }

        logger.info("******Finish TC003 login DDT test********");
    }
}

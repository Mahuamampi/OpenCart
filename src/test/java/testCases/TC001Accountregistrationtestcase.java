package testCases;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;


import java.time.Duration;

public class TC001Accountregistrationtestcase extends BaseClass {







    @Test(groups = {"Regression","Master"})
    public void verify_account_registration() {

        logger.info("****** Starting TC001Accountregistrationtestcase ****** ");

        try {

            Homepage hp = new Homepage(driver);

            hp.clickmyaccount();

            logger.info("Clicked on my account ");
            hp.clickRegister();
            logger.info("Clicked on register ");

            AccountRegistrationPage regis = new AccountRegistrationPage(driver);

            logger.info("Providing customer details");

            // regis.setFirstname("Mickey");

            //set first name and last name with random
            //regis.setLastname("Minnie");

            regis.setFirstname(randomString().toUpperCase());
            regis.setLastname(randomString().toUpperCase());
            //regis.setEmail("guttu@gmail.com");

            //Use random mail id
            regis.setEmail(randomString() + "@gmail.com");
            //regis.settelhephone("23232345");
            //Using random number

            regis.settelhephone(randomNumber());

            //  regis.setPassword("abc12345");
            //regis.setTxtConfirmpassword("abc12345");
            //set password and confirm  with random

            String password = randomalphanumeric(); //Will store the value in the password variable
            regis.setPassword(password);
            regis.setTxtConfirmpassword(password);


            regis.setprivacy();
            regis.clickcontinue();


            logger.info("Validating expected message");
            String conf = regis.getconfirmationmsg();
            Assert.assertEquals(conf, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test case got failed");
            logger.debug("Debug logs");
            Assert.fail();
        }

        logger.info("****** Finished TC001Accountregistrationtestcase ******");


    }

}

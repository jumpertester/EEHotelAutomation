package testng;

import helper.Interactions;
import helper.Launcher;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBooking {

    WebDriver driver;
    Interactions interactions;

    @BeforeMethod
    public void before(){
        driver = Launcher.getChromeDriver();
        Launcher.getBrowser(driver);
        interactions = new Interactions(driver);
    }

    @Test
    public void deleteBooking(){
        //create booking
        interactions.createBooking();

        //get current number of applications
        int currentNumberOfBookings = interactions.getNumberOfBookings();

        //delete booking
        interactions.deleteBooking();

        //assert
        System.out.println("Expected " + Integer.toString(currentNumberOfBookings -1));
        System.out.println("Actual " + Integer.toString(interactions.getNumberOfBookings()));
        Assert.assertEquals(interactions.getNumberOfBookings(), currentNumberOfBookings -1);
    }

    @AfterMethod
    public void after(){
        driver.close();
    }

}

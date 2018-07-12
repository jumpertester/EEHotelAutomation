package testng;

import helper.Interactions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helper.Launcher;

public class CreateBooking {

    WebDriver driver;
    Interactions interactions;

    @BeforeMethod
    public void beforeMethod(){
        driver = Launcher.getChromeDriver();
        Launcher.getBrowser(driver);
        interactions = new Interactions(driver);
    }

    @Test
    public void createBookingTest(){
        //get current number of applications
        int currentNumberOfBookings = interactions.getNumberOfBookings();

        //create booking
        interactions.createBooking();

        //assert number of bookings increased by 1
        System.out.println("Expected " + Integer.toString(currentNumberOfBookings + 1));
        System.out.println("Actual " + Integer.toString(interactions.getNumberOfBookings()));
        Assert.assertEquals(interactions.getNumberOfBookings(), currentNumberOfBookings + 1 );
    }

    @AfterMethod
    public void AfterMethod(){
        driver.close();
    }

}

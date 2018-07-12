package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HotelPage;

public class Interactions {
    WebDriver driver;
    HotelPage hotelPage;

    public Interactions(WebDriver driver){
        this.driver = driver;
        hotelPage = new HotelPage(driver);
    }

    public void createBooking()
    {
        hotelPage.enterFirstName("Test");
        hotelPage.enterSurname("TESTAA");
        hotelPage.enterPrice("100");
        hotelPage.isDepositPaid(true);
        hotelPage.setCheckInDate("2018-12-30");
        hotelPage.setCheckOutDate("2018-12-31");
        saveBooking();
    }

    public int getNumberOfBookings(){
        return hotelPage.getListOfBookings().size();
    }

    public void saveBooking(){
        int currentNumberOfBookings = getNumberOfBookings();
        hotelPage.clickSave();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                int numberOfBookings = getNumberOfBookings();
                if (numberOfBookings == currentNumberOfBookings + 1)
                    return true;
                else
                    return false;
            }
        });
    }

    public void deleteBooking(){
        int currentNumberOfBookings = getNumberOfBookings();
        hotelPage.clickDelete();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                int numberOfBookings = getNumberOfBookings();
                if (numberOfBookings == currentNumberOfBookings - 1)
                    return true;
                else
                    return false;
            }
        });
    }
}
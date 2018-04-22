package tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.bookings;
import utilities.ExcelFileUtilities;
import utilities.hotelBookingUtilities;
import java.io.IOException;

public class HotelBookingScenarios {

    WebDriver driver;

    String hotelBookingDataDirectory = "src/main/resources";
    String hotelBookingDataFileName = "HotelBookingsData.xlsx";
    String hotelBookingSheetName = "HotelBookings";
    int rowno;

    Sheet bookingScenarioData;
    String randomName;

    bookings objBookings;

    // Add a booking
    @Test
    public void hotelBookingScenario01() throws Exception {

        bookings objBookings;

        int activeRowNo = 1;
        objBookings = new bookings(driver);
        randomName = objBookings.populateBookings(bookingScenarioData,activeRowNo);
}
    // Add a booking, and delete it
    @Test
    public void hotelBookingScenario02() throws Exception {

        bookings objBookings;

        int activeRowNo = 2;
        objBookings = new bookings(driver);
        randomName = objBookings.populateBookings(bookingScenarioData,activeRowNo);

        objBookings.deleteBookingAndAssert(driver, randomName);
    }

    // Add three booking, and delete the second one
    @Test
    public void hotelBookingScenario03() throws Exception {

        bookings objBookings1;
        bookings objBookings2;
        bookings objBookings3;

        String  randomName1;
        String  randomName2;
        String  randomName3;

        int activeRowNo1 = 3;
        objBookings1 = new bookings(driver);
        randomName1 = objBookings1.populateBookings(bookingScenarioData,activeRowNo1);

        int activeRowNo2 = 4;
        objBookings2 = new bookings(driver);
        randomName2 = objBookings2.populateBookings(bookingScenarioData,activeRowNo2);

        int activeRowNo3 = 5;
        objBookings3 = new bookings(driver);
        randomName3 = objBookings3.populateBookings(bookingScenarioData,activeRowNo3);

        objBookings2.deleteBookingAndAssert(driver, randomName2);
    }


    @BeforeSuite
    public void setupBeforSuite() throws IOException {

        System.out.println("\nReading data from Excel spreadsheets....\n");


        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);

        bookingScenarioData = ExcelFileUtilities.readExcel(hotelBookingDataDirectory,
                hotelBookingDataFileName, hotelBookingSheetName);
    }

    @BeforeMethod
    public void setupBeforeTest() {

        driver = hotelBookingUtilities.setup();

    }

    @AfterMethod
    public void teardownAfterTest() {

        driver.close();

    }

}
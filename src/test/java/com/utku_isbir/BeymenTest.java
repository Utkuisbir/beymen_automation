package com.utku_isbir;


import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.ProductPage;

public class BeymenTest {
    public static void Sleep(String[] args) {
        System.out.println("Sleep start");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sleep end.");
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void beymenWebsiteAutomation() {



        List<String> excelData = null;

        try {
            excelData = ExcelDataRead.readData(null);
        } catch (IOException e) {
            System.out.print("başarısız");
            e.printStackTrace();
        }
        String searchTerm = excelData.get(0);
        String secondSearchTerm = excelData.get(1);



        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.enterSearchKeyword(searchTerm);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.clearSearchBox();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.enterSearchKeyword(secondSearchTerm);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.pressEnterKey();

           try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ProductPage productPage = new ProductPage(driver);

        try {
            productPage.selectRandomProductAndAddToCart();
        } catch (IOException e) {
            System.out.println("selectRandomProductAndAddToCart error");
        }
        


    }
}

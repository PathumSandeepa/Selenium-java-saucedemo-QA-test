package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
    ChromeDriver driver;

    public static void main(String[] args) {

    }

    //Add Before class
    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().browserVersion("108.0.5359.99").setup();
        driver = new ChromeDriver();
    }

    //create test case
    @Test
    public void TestCaseCreate() throws InterruptedException {
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        //Get current url
        String currentUrl = driver.getCurrentUrl();

        //Check whether the expected url is as same the current url in the browser
        Assert.assertEquals(currentUrl, url);

        //find username text box
        WebElement userNameFind = driver.findElement(By.id("user-name"));
        //type username
        userNameFind.sendKeys("standard_user");

        //find password box
        WebElement passwordFind = driver.findElement(By.id("password"));
        //type password
        passwordFind.sendKeys("secret_sauce");

        //click login button
        WebElement clickLoginBTN = driver.findElement(By.id("login-button"));
        clickLoginBTN.click();

        //webdriver wait 2sec
        Thread.sleep(3000);

        //find add to cart btn 1
        WebElement findAddToCart_1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        //click add to cart
        findAddToCart_1.click();

        // find another add to cart button 2
        WebElement findAddToCart_2 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
        //click add to cart
        findAddToCart_2.click();

        //go to cart - find cart
        WebElement findCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        //click cart icon
        findCart.click();

        //Webdriver wait
        Thread.sleep(3000);

        //First product check

        //check actual product name 1 = expected product name 1
        WebElement checkProductName_1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        //get product name
        String productName_1 = checkProductName_1.getText();
        String expectedProductName_1 = "Sauce Labs Backpack";
        //compare
        Assert.assertEquals(productName_1, expectedProductName_1);

        //check actual product price 1 = expected product price 1
        WebElement checkProductPrice_1 = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
        //get product price
        String productPrice_1 = checkProductPrice_1.getText();
        String expectedProductPrice_1 = "$29.99";
        //compare
        Assert.assertEquals(productPrice_1, expectedProductPrice_1);

        //Wb driver wait
        Thread.sleep(2000);

        //second product check

        //check actual product name 2 = expected product name 2
        WebElement checkProductName_2 = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div"));
        //get product name
        String productName_2 = checkProductName_2.getText();
        String expectedProductName_2 = "Sauce Labs Bike Light";
        //compare
        Assert.assertEquals(productName_2, expectedProductName_2);


        //check actual product price 2 = expected product price 2
        WebElement checkProductPrice_2 = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div"));
        //get product price
        String productPrice_2 = checkProductPrice_2.getText();
        String expectedProductPrice_2 = "$9.99";
        //compare
        Assert.assertEquals(productPrice_2, expectedProductPrice_2);

        //remove first product from cart
        WebElement removeFirstItem = driver.findElement(By.name("remove-sauce-labs-backpack"));
        removeFirstItem.click();

        //remove second from cart
        WebElement removeSecondItem = driver.findElement(By.name("remove-sauce-labs-bike-light"));
        removeSecondItem.click();

        //click continue shopping button
        WebElement clickContinueShopping = driver.findElement(By.id("continue-shopping"));
        clickContinueShopping.click();

        //web driver wait
        Thread.sleep(3000);

        //click menu icon
        WebElement clickMenu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        clickMenu.click();

        //web driver wait
        Thread.sleep(3000);

        //click log out
        WebElement clickLogOut = driver.findElement(By.id("logout_sidebar_link"));
        clickLogOut.click();


    }



}
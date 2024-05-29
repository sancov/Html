package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Guru99 {
    static WebDriver driver;

    @FindBy(xpath = "//*[@id='navbar-brand-centered']/ul/li[1]/a")  public static WebElement navBar_Selenium;

    public Guru99(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }

    public static WebElement getFirstMenuElement(String menu){
        if(menu.equals("Selenium"))
            return navBar_Selenium;
        else{
            return driver.findElement(By.linkText(menu));
        }
    }

    public static void pressMenu1(WebElement menu1) {
        Actions act = new Actions(driver);
        act.moveToElement(menu1).click().build().perform();
    }

    public static void pressMenu2(String menu2) {
        Actions act = new Actions(driver);
        if(menu2.length() > 0) {
            WebElement menu2_element = driver.findElement(By.linkText(menu2));
            act.moveToElement(menu2_element).click().build().perform();
        }
    }

    public static void navBar(String menu1AndMenu2) {
        String[] parts = menu1AndMenu2.split(";");
        if (parts.length == 1) {
            String menu1 = parts[0];
            pressMenu1(getFirstMenuElement(menu1));
        }
        else if(parts.length == 2){
            String menu1 = parts[0];
            String menu2 = parts[1];
            Guru99.pressMenu1(getFirstMenuElement(menu1));
            Guru99.pressMenu2(menu2);
        }
    }

    public static void navBar(String menu1, String menu2) {
            Guru99.pressMenu1(Guru99.getFirstMenuElement(menu1));
            Guru99.pressMenu2(menu2);
        }
    }






package interview;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.Guru99;

public class Test2 extends Base{
    static Guru99 guru99;

    @BeforeMethod
    public void before(){
        guru99 = new Guru99(driver);
    }

    @Test(description = "test clicking on menu : 'Selenium', sub-menu: 'Table Demo'")
    public static void tc1() {
        driver.get("http://demo.guru99.com/");
        guru99.navBar("Selenium", "Table Demo");
    }

    @Test(description = "test clicking on menu : 'Insurance Project'")
    public static void tc2() {
        driver.get("http://demo.guru99.com/");
        guru99.navBar("Insurance Project");
    }

    @Test(description = "test clicking on menu : 'SEO', sub-menu: 'Page-2'    -data sent in 2 parameters")
    public static void tc3() {
        driver.get("http://demo.guru99.com/");
        guru99.navBar("SEO", "Page-2");
    }

    @Test(description = "test clicking on menu : 'SEO', sub-menu: 'Page-2'    -data sent in 1 parameters")
    public static void tc4() {
        driver.get("http://demo.guru99.com/");
        guru99.navBar("SEO;Page-2");
    }
}

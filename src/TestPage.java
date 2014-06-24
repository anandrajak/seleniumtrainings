
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: victoriazhukovskaya
 * Date: 10.07.12
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */

/// Базовый клас для всех страниц
public abstract class TestPage {
    private static int SELENIUM_WAITTOPAGETOLOAD = 10000;
    static WebDriver driver;
    public static String cssLinkToEmptyReg = "html body div#content div#landing-content div.center-block div#right-pole form#register-form div.register-block div#slider-wrap-btn div.mt-sm span.slider";
    public static String idSettingsMenu = "settings";
    public static String linkTextLogout = "Выйти";
    public static String idProfileMenu = ".user-name.trebuchet.ellipsis";

    public static String cssBtnSureLogout = "a.btn.btn-blue.yes";

    public static void pressProfileMenu() {
        driver.findElement(By.cssSelector(idProfileMenu)).click();

    }

    public static void setdriver(WebDriver newdriver) {
        driver = newdriver;
    }

    public static void clickOnLinkByText (String text) throws InterruptedException {
        Thread.currentThread().sleep(SELENIUM_WAITTOPAGETOLOAD / 2);
        driver.findElement(By.linkText(text)).click();
    }

    public static void EmptyFormReg() {
        if (driver.getCurrentUrl().endsWith("/?id=4"))
            driver.findElement(By.cssSelector(cssLinkToEmptyReg)).click();

    }



}

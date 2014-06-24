import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: victoriazhukovskaya
 * Date: 10.07.12
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class ProfilePage extends TestPage {

    public static String cssHeaderOnline = "span.profile-header-online";
    public static String cssNameOnTop = ".user-name.trebuchet.ellipsis";
    public static String cssNameInForm = ".h1-username-text.ellipsis.arial";
    public static String idGender = "user_sex-content";
    public static String cssMssgMail = "div.fs-content-box div.fs-full-content div.fs-inner-box a";
    public static String cssCityAge = "div.fs-bar-city-user";
    public static String idCity = "user_citycountry-content";
    public static String idBD = "birthday-content";


    // проверка что пользователь онлайн
    public static boolean checkStatusOnline() {
        WebElement element = driver.findElement(By.cssSelector(cssHeaderOnline));
        return element.getText().equalsIgnoreCase("online");
    }


    public static boolean checkNameOnTop(String name) {
        // WebElement element = driver.findElement(By.cssSelector("div#Container div#contentBody.ownHome div.fs-content-box h2 a"));
        WebElement element = driver.findElement(By.cssSelector(cssNameOnTop));

        return element.getText().equalsIgnoreCase(name);
    }


    public static boolean checkNameInForm(String name) {
        WebElement element = driver.findElement(By.cssSelector(cssNameInForm));
        return element.getText().contentEquals(name);
    }


    public static boolean checkGender(String gen) {

        WebElement element = driver.findElement(By.id(idGender));
        return element.getText().contentEquals(gen);
    }

    public static boolean checkMessageAboutEmail(String email) {
        WebElement element = driver.findElement(By.cssSelector(cssMssgMail));
        return element.getText().contentEquals(email);
    }

    public static boolean checkCityAndAge(String cityage) {
        WebElement element = driver.findElement(By.cssSelector(cssCityAge));
        return element.getText().contentEquals(cityage);

    }

    public static boolean checkCity(String city) {
        WebElement element = driver.findElement(By.id(idCity));
        return element.getText().contentEquals(city);

    }

    public static boolean checkBD(String BD) {
        WebElement element = driver.findElement(By.id(idBD));
        return element.getText().contentEquals(BD);
    }


}

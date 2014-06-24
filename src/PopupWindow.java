import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: victoriazhukovskaya
 * Date: 10.07.12
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public abstract class PopupWindow extends TestPage {
    static final String cssCloseIcon = "html body.ru div#popupWin div#popupClose.icon-circle i.icon";
    static final String idCloseIcon = "popupClose";
    //html body.ru div#popupWin div#popupClose.icon-circle i.icon
    static final String idPopupTitle = "popupTitle";
    static final String idCancelMailruPopup = ".btn[onclick=\"iPopup.close();\"]";


    // взять заголовок окна подтверждения емейла
    public static String getTitleEmailConfirmationPopup() {

        return driver.findElement(By.id(idPopupTitle)).getText();

    }

    // Закрыть попап окно о подтверждение емейла
    public static void closeEmailConfirmationPopup()

    {
        try {
            driver.findElement(By.cssSelector(cssCloseIcon)).click();
        } catch (Exception ex) {
            System.out.println("There is no popup window");
        }

    }

    // Закрыть попап окно о подтверждение возраста
    public static void closeAgeConfirmationPopup()

    {
        driver.findElement(By.id(idCloseIcon)).click();


    }

    //закрыть попап окно о подтверждении почты на mail.ru
    public static void closeMailruConfirmationPopup () {
        driver.findElement(By.cssSelector(idCancelMailruPopup)).click();
    }

}


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: victoriazhukovskaya
 * Date: 10.07.12
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */


public abstract class LoginPage extends TestPage {

    private static int SELENIUM_WAITTOPAGETOLOAD = 10000;

    // локаторы на странице логина к фотостране
    public static final String editBoxName = "input#userName";
    public static final String editBoxEmail = "input#userEmail";
    public static final String genderW = ".gender-select.gender-w";
    public static final String genderM = "div.gender-select.gender-m";
    public static final String linkLicense = "пользовательским соглашением";
    public static final String hrefLicense = "http://fotostrana.ru/support/help/";
    public static final String buttonRegister = "button#btnRegister.btn";
    public static final String dayList = "input[placeholder=День]";
    public static final String monthList = "input[placeholder=Месяц]";
    public static final String yearList = "input[placeholder=Год]";
    //TODO: вынести в отдельный класс страницу переходов после регистрации
    public static final String declinePhotoButton = "div.ibtn.fl-r";

    // Локаторы для регистрации через мой мир
    public static final String locatorMoyMirLogin = "Login";
    public static final String locatorMoyMirPassword = "Password";
    public static final String locatorMoyMirBtnSubmit = "button.btn";

    // Локаторы для регистрации через VK
    public static final String locatorVkLogin = "email";
    public static final String locatorVkPassword = "pass";
    public static final String locatorVkBtnSubmit = "install_allow";

    // Локаторы для регистрации через Odnoklassniki
    public static final String locatorOdLogin = "fr.email";
    public static final String locatorOdPassword = "fr.password";
    public static final String locatorOdBtnSubmit = "button_continue";
    public static final String locatorOdBtnAcc = "button.button-pro.form-actions__yes";

    // Локаторы для регистрации через YARU
    public static final String locatorYaRuLogin = "login";
    public static final String locatorYaRuPassword = "passwd";
    public static final String locatorYaRuBtnSubmit = "allow";
    public static final String locatorYaRuBtnAcc = "deny";

    // Локаторы для регистрации через FB
    public static final String locatorFbLogin = "input[name=\"email\"]"; //"email";
    public static final String locatorFbPassword = "input[name=\"pass\"]";//"pass";
    public static final String locatorFbBtnSubmit = "input[value=\"Войти\"]"; //"login";
    public static final String locatorFbBtnAcc = "grant_clicked";


    // Локаторы кнопок социальных сетей
    public static final String btnMailRu = "*[data_text=\"Mail.ru\"]";
    public static final String btnVk  = "*[data_text=\"Вконтакте\"]";
    public static final String btnOdnoklassniki  = "*[data_text=\"Одноклассники\"]";
    public static final String btnYa  = "*[data_text=\"Яндекс\"]";
    public static final String btnFb  ="*[data_text=\"Facebook\"]";


    // ввести имя
    public static void enterName(String name) {
        WebElement element = driver.findElement(By.cssSelector(editBoxName));
        element.sendKeys(name);

    }

    // ввести емейл
    public static void enterEmail(String email) {

        WebElement element = driver.findElement(By.cssSelector(editBoxEmail));
        element.clear();
        element.sendKeys(email);


    }

    // ввести пол - жен
    public static void enterGenderW() {
        driver.findElement(By.cssSelector(genderW)).click();
    }

    // проверить наличие ссылки на пользовательское соглашение
    public static boolean checkAgreementLink() {
        WebElement element = driver.findElement(By.linkText(linkLicense));
        return element.getAttribute("href").equalsIgnoreCase(hrefLicense);
    }


    // нажать кнопку зарегистрироваться
    public static void pressRegisterButton() {
        driver.findElement(By.cssSelector(buttonRegister)).click();

    }

    //выбрать день в дате рождения
    public static void selectDayBirth(String day) {
        driver.findElement(By.cssSelector(dayList)).click();
        driver.findElement(By.cssSelector("div[data-value=\""+day+"\"]")).click();
    }


    //выбрать месяц в дате рождения
    public static void selectMonthBirth(String month) {
        driver.findElement(By.cssSelector(monthList)).click();
        driver.findElement(By.cssSelector("div[data-value=\""+month+"\"]")).click();
    }

    //выбрать год в дате рождения
    public static void selectYearBirth(String year) {
        driver.findElement(By.cssSelector(yearList)).click();
        driver.findElement(By.cssSelector("div[data-value=\""+year+"\"]")).click();
    }

    // нажать кнопку Mail.ru
    public static void pressMailRuButton() {
        driver.findElement(By.cssSelector(btnMailRu)).click();

    }

    // нажать кнопку Vk
    public static void pressVkButton() {
        driver.findElement(By.cssSelector(btnVk)).click();

    }


    // нажать кнопку Одноклассники
    public static void pressOdnoklassnikiButton() {
        driver.findElement(By.cssSelector(btnOdnoklassniki)).click();

    }


    // нажать кнопку YaRu
    public static void pressYaRuButton() {
        driver.findElement(By.cssSelector(btnYa)).click();

    }

    // нажать кнопку FB
    public static void pressFbButton() {
        driver.findElement(By.cssSelector(btnFb)).click();

    }

    //нажать на кнопку отказа от загрузки фотографий
    public static void declinePhotoUpload() throws InterruptedException {
        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD / 5);
        driver.findElement(By.cssSelector(declinePhotoButton)).click();
    }

    // Заполнения формы регистрации через мой мир + поиск формы(окна)
    public static void registerViaMoyMir(String login, String password) {
        // переключаемся на окно логина через мой мир
        Set<String> hendles = (driver.getWindowHandles());
        // оно второе в списке
        String strHendelMoyMir = hendles.toArray()[1].toString();

        // драйвер без логирования



        // переключение на окно регистрации через мой мир (пользователь уже зарегестрирован)
        driver.switchTo().window(strHendelMoyMir);
        //.getTitle();

        try {
            Thread.sleep(SELENIUM_WAITTOPAGETOLOAD / 2);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        WebElement element = driver.findElement(By.name(locatorMoyMirLogin));
        element.sendKeys(login);

        element = driver.findElement(By.name(locatorMoyMirPassword));
        element.sendKeys(password);

        element = driver.findElement(By.cssSelector(locatorMoyMirBtnSubmit));
        try {
            element.submit();

            driver.switchTo().window(hendles.toArray()[0].toString());

        } catch (IllegalMonitorStateException e) {

        } catch (Exception e) {
            // тут теряется драйвер потому что закрывается окно но в нашем случае это правильно
        } finally {
            driver.switchTo().window(hendles.toArray()[0].toString());

            try {
                Thread.sleep(SELENIUM_WAITTOPAGETOLOAD / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (BaseTest.strDriver.compareToIgnoreCase("Chrome") != 0)
                driver.manage().window().maximize();

        }


    }

    // Заполнения формы регистрации через vk + поиск формы(окна)
    public static void registerViaVk(String login, String password) {
        // переключаемся на окно логина через мой мир
        Set<String> hendles = (driver.getWindowHandles());
        // оно второе в списке
        String strHendelVk = hendles.toArray()[1].toString();

        // драйвер без логирования



        // переключение на окно регистрации через мой мир (пользователь уже зарегестрирован)
        driver.switchTo().window(strHendelVk);
        //.getTitle();

        WebElement element = driver.findElement(By.name(locatorVkLogin));
        element.sendKeys(login);

        element = driver.findElement(By.name(locatorVkPassword));
        element.sendKeys(password);

        try {
            element = driver.findElement(By.id(locatorVkBtnSubmit));
            element.submit();//.click();
            element.click();

            driver.switchTo().window(hendles.toArray()[0].toString());
        } catch (IllegalMonitorStateException e) {
            System.out.println("IllegalMonitorStateException");

        } catch (Exception e) {
            // тут теряется драйвер потому что закрывается окно но в нашем случае это правильно
        } finally {

            driver.switchTo().window(hendles.toArray()[0].toString());

            try {
                Thread.sleep(SELENIUM_WAITTOPAGETOLOAD);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            element = driver.findElement(By.name("map_user_email"));

            element.sendKeys(login);
            element = driver.findElement(By.cssSelector("div#mapUserForm1 form div.btn"));
            element.click();

        }

    }

    // Заполнения формы регистрации через одноклассники + поиск формы(окна)
    public static void registerViaOdnoklassniki(String login, String password) {
        // переключаемся на окно логина через мой мир
        Set<String> hendles = (driver.getWindowHandles());
        // оно второе в списке
        String strHendelOd = hendles.toArray()[1].toString();

        // драйвер без логирования



        // переключение на окно регистрации через одноклассники (пользователь уже зарегистрирован)
        driver.switchTo().window(strHendelOd);

        WebElement element = driver.findElement(By.name(locatorOdLogin));
        element.sendKeys(login);

        element = driver.findElement(By.name(locatorOdPassword));
        element.sendKeys(password);

        element = driver.findElement(By.cssSelector(locatorOdBtnAcc));




        driver.switchTo().window(hendles.toArray()[0].toString());

        TheThreadSleep();
/*
        try {
            element.sendKeys(Keys.RETURN);
			//element = driver.findElement(By.name(locatorOdBtnSubmit));
            //element.click();
            //element = driver.findElement(By.name(locatorOdBtnAcc));


            //element.click();


            driver.switchTo().window(hendles.toArray()[0].toString());

        } catch (IllegalMonitorStateException e) {

        } catch (Exception e) {
            // тут теряется драйвер потому что закрывается окно но в нашем случае это правильно
        } finally {

            driver.switchTo().window(hendles.toArray()[0].toString());

            try {
                Thread.sleep(SELENIUM_WAITTOPAGETOLOAD);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

  */
            //if (BaseTest.strDriver.compareToIgnoreCase("Chrome") != 0)
            //    driver.manage().window().maximize();
     //       element = driver.findElement(By.name("map_user_email"));
     //       element.sendKeys(login);
     //       element = driver.findElement(By.cssSelector("div#mapUserForm1 form div.btn"));
     //       element.click();
  //      }


    }

    // Заполнения формы регистрации через yaru + поиск формы(окна)
    public static void registerViaYaRu(String login, String password) {
        // переключаемся на окно логина через мой мир
        Set<String> hendles = (driver.getWindowHandles());
        // оно второе в списке
        String strHendelYa = hendles.toArray()[1].toString();

        // драйвер без логирования



        // переключение на окно регистрации через одноклассники (пользователь уже зарегистрирован)
        driver.switchTo().window(strHendelYa);

        WebElement element = driver.findElement(By.name(locatorYaRuLogin));
        element.sendKeys(login);

        element = driver.findElement(By.name(locatorYaRuPassword));
        element.sendKeys(password);

        element = driver.findElement(By.name(locatorYaRuBtnSubmit));



        driver.switchTo().window(hendles.toArray()[0].toString());

        TheThreadSleep();

        if (BaseTest.strDriver.compareToIgnoreCase("Chrome") != 0)
            driver.manage().window().maximize();

    }

    // Заполнения формы регистрации через FaceBook + поиск формы(окна)
    public static void registerViaFbRu(String login, String password) {
        // переключаемся на окно логина через мой мир
        Set<String> hendles = (driver.getWindowHandles());
        // оно второе в списке
        String strHendelFb = hendles.toArray()[1].toString();

        // драйвер без логирования



        // переключение на окно регистрации через одноклассники (пользователь уже зарегистрирован)
        driver.switchTo().window(strHendelFb);
        try {
            Thread.sleep(SELENIUM_WAITTOPAGETOLOAD);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        WebElement element = driver.findElement(By.cssSelector(locatorFbLogin));
        element.sendKeys(login);

        element = driver.findElement(By.cssSelector(locatorFbPassword));
        element.sendKeys(password);

        try {
            element = driver.findElement(By.cssSelector(locatorFbBtnSubmit));
            element.submit();
            element = driver.findElement(By.name(locatorFbBtnAcc));
            element.submit();


            driver.switchTo().window(hendles.toArray()[0].toString());

        } catch (IllegalMonitorStateException e) {

        } catch (Exception e) {
            // тут теряется драйвер потому что закрывается окно но в нашем случае это правильно
        } finally {

            driver.switchTo().window(hendles.toArray()[0].toString());

            try {
                Thread.sleep(SELENIUM_WAITTOPAGETOLOAD * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


        }
    }

/*    static void closeTheWndByBtn(WebElement element) {
        CloseWndInThread thread = new CloseWndInThread();
        thread.setElement(element);
        thread.start();
        TheThreadSleep();
        thread.interrupt();

    }*/

    static void TheThreadSleep() {
        try {
            Thread.sleep(SELENIUM_WAITTOPAGETOLOAD);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    //todo Is it actual code? (Victoria's question )
    // Single Mode Webdriver
    public static void registerViaOdnoklassnikiTitleSingle(String login, String password) {

        String title = "Одноклассники";
        String parentWindowHandle = driver.getWindowHandle();

        // переключаемся на окно логина через мой мир
        //Set<String> hendles = (driver.getWindowHandles());
        // оно второе в списке
        //String strHendelOd = hendles.toArray()[1].toString();

        // драйвер без логирования
        //WebDriver driver = driver;


        // переключение на окно регистрации через одноклассники (пользователь уже зарегистрирован)
        //driver.switchTo().window(strHendelOd);


        WebElement element = driver.findElement(By.name(locatorOdLogin));
        element.sendKeys(login);

        element = driver.findElement(By.name(locatorOdPassword));
        element.sendKeys(password);


        element.sendKeys(Keys.RETURN);
        driver.switchTo().window(parentWindowHandle);

        try {
            Thread.sleep(SELENIUM_WAITTOPAGETOLOAD);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        if (BaseTest.strDriver.compareToIgnoreCase("Chrome") != 0)
            driver.manage().window().maximize();
        element = driver.findElement(By.name("map_user_email"));
        element.sendKeys(login);
        element = driver.findElement(By.cssSelector("div#mapUserForm1 form div.btn"));
        element.click();
    }





}

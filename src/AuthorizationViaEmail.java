import org.junit.Test;
import util.ReadingEmail;
import util.UsingHttpClient;

import java.util.ArrayList;

/**
 * Created by ko4 on 13.06.2014.
 */
public class AuthorizationViaEmail extends BaseTest{
    public static final String dataEmail = "test276@mail.ru";
    public static final String dataName = "Тестовоеимя";
    public static final String dataPassword = "double805";
    static public String strBaseURL = "http://fotostrana.ru/start/testing/";
    private static int SELENIUM_WAITTOPAGETOLOAD = 10000;
    @Test(timeout = 180000)
    public void testAuthorizationViaEmail() throws Exception {
        getDriver("Sauce");
        TestPage.setdriver(driver);
//        getDriver("FF");
//        TestPage.setdriver(driver);
        try {
            //удалить предидущего юзера
            UsingHttpClient.invokeGetHttp("?key=ffb507eb5a940702d4205ca14fcbbeb3&email=" + dataEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String LogErrors = "";

        // переход на базовый урл
        driver.get(strBaseURL);

        // удаляем все куки
        driver.manage().deleteAllCookies();

        // разворачиваем окно браузера на весь экран. если это не хром
        if (strDriver.compareToIgnoreCase("Chrome") != 0)
            driver.manage().window().maximize();

/*        //В ИУ попадаем всегда сюда - нужно перейти на обычную регистрацию "﻿http://fotostrana.ru/start/photolanding/wall/?id=4");
        TestPage.EmptyFormReg();*/

        // ввести имя
        LoginPage.enterName(dataName);

        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD/5);

        // ввести е-мейл
        LoginPage.enterEmail(dataEmail);

        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD/5);

        // ввести пол женский
        LoginPage.enterGenderW();
        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD/5);

        //проверить наличие ссылки пользовательского соглашения
        if (!LoginPage.checkAgreementLink())
            LogErrors += ("Нет ссылки пользовательского соглашения \r\n");

        String[] randomDate = generateRandomDate(true);



        //выбираем первое число месяца даты рождения
        LoginPage.selectDayBirth(randomDate[0]);
        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD/5);
        //выбираем январь
        LoginPage.selectMonthBirth(randomDate[1]);
        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD/5);
        //выбираем 1985 год
        LoginPage.selectYearBirth(randomDate[2]);
        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD/5);
        // Нажать кнопку зарегистрироваться
        LoginPage.pressRegisterButton();

        Thread.currentThread().sleep(SELENIUM_WAITTOPAGETOLOAD);

        //Нажать кнопку отмены попапа Mail.ru

        //TODO: Не забыть подумать как правильно реализовать эту логику

        PopupWindow.closeMailruConfirmationPopup();





        // Закрыть попап окно о подтверждение емейла
        PopupWindow.closeEmailConfirmationPopup();

        //Thread.currentThread().sleep(ConfigData.SELENIUM_WAITTOPAGETOLOAD);

        //TODO: обернуть в метод


        Thread.sleep(SELENIUM_WAITTOPAGETOLOAD);

        ArrayList s = ReadingEmail.getLinksFromLastLastEmail("test276@mail.ru", "qwerasd");

        driver.get(s.get(0).toString());

        LoginPage.clickOnLinkByText("Не сейчас, обещаю добавить фото позже");

        LoginPage.declinePhotoUpload();




        // Разлогиниться
        //logout();


        // Авторизация
        //autViaEmail(dataEmail, dataPassword);


        //----
        // Закрыть попап окно о подтверждение емейла
        //PopupWindow.closeEmailConfirmationPopup();

        //Thread.currentThread().sleep(ConfigData.SELENIUM_WAITTOPAGETOLOAD / 2);

        //TODO: написать тест на пользователя меньше 16
        //LoginPage.clickOnLinkByText("Спасибо, разберусь сам");


        //переход на страницу профайла
        TestPage.pressProfileMenu();



        // Закрыть попап окно о подтверждение емейла
        //PopupWindow.closeEmailConfirmationPopup();


        //Thread.currentThread().sleep(ConfigData.SELENIUM_WAITTOPAGETOLOAD);

        // проверяем имя пользователя в шапке
        if (!ProfilePage.checkNameOnTop(dataName))
            LogErrors += ("Имя пользователя в шапке на странице профайла не соотвествует указанному при регистрации\r\n");

        // проверка статуса пользователя - онлайн
        //TODO: неприменимо без загруженной аватарки
        //if (!ProfilePage.checkStatusOnline())
        //    LogErrors += ("Статус пользователя не онлайн \r\n");

        // проверка имени пользователя в анкете
        if (!ProfilePage.checkNameInForm(dataName))
            LogErrors += ("Имя пользователя в анкете не соответствует указанному при регистрации\r\n");


        // проверка пола
        //if (!ProfilePage.checkGender("Женский"))
        //    LogErrors += ("Пол не женский\r\n");


        org.junit.Assert.assertEquals(LogErrors, "", LogErrors);
        System.out.println("!!!!!!!!!!!!!!! LOGERROR" + LogErrors);

    }

}



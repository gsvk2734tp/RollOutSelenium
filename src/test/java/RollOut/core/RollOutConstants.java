package RollOut.core;

import org.openqa.selenium.By;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Класс с константами для RollOut
 */

public class RollOutConstants {
    //URL
    public static final String URL_WINDOWS_SITE = "https://nsms-t-srv-02:8090"; // 10.0.15.237
    public static final String URL_WINDOWS_USERS = "https://nsms-t-srv-02:8090/users"; // 10.0.15.237
    public static final String URL_WINDOWS_AUTH = "https://nsms-t-srv-02:8811"; // 10.0.15.237

    //Общие константы
    public static final String SPEC_SYMBOLS = "!#$%&'*+-/=?^_`{|";
    public static final String TITLE_APP = "ViPNet Rollout Center";
    public static final String orgName = "Сеть организации 1";
    public static final By BUTTON_DELETE_PRESS_YES_USER_AND_ORG = By.cssSelector("button.actions_button:nth-child(1)");
    public static final By SELECT_LANGUAGE_AUTH = By.cssSelector(".language-dropdown-toggle-text");
    static final By LOGO = By.className("brand_logo");
    static final By LOGO_VIPNET = By.xpath("//span[text()='ViPNet']");
    static final By LOGO_NSMS = By.xpath("//span[text()='Rollout Center']");

    //Страницы авторизации
    public static final String TITLE_SILSO = "ViPNet Network Security Management System";
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "123123123";
    public static final By NAME_FIElD = By.id("UserName");
    public static final By PASSWORD_FIELD = By.id("Password");
    public static final By LOGIN_BUTTON = By.cssSelector("button.btn-login");

    //Страница организации
    public static final By BUTTON_EDIT_ORG = By.cssSelector("tr.active .icons-general-edit");
    public static final By BUTTON_DELETE_ORG = By.cssSelector("tr.active .icons-general-delete");
    public static final By BUTTON_CANCEL_ORG = By.cssSelector("button:nth-child(2)");
    public static final By BUTTON_ADD_ORG = By.cssSelector("a.toolbar_button");
    public static final By BUTTON_SAVE_ORG = By.cssSelector("button.actions_button");
    public static final By DROPDOWN_SELECT_ORG = By.cssSelector("span.ng-option-label");
    public static final By FIELD_URI_ORG = By.cssSelector("input.content_field-text-input");
    public static final By FIELD_NAME_ORG = By.cssSelector("div.ng-input input");
    public static final By ORG_CURRENT_NAME = By.cssSelector(".ng-value-label");
    public static final By FIELD_ERROR_ORG = By.cssSelector(".error.ng-star-inserted");

    //Страница пользователи
    public static final By BUTTON_ADD_USER = By.cssSelector("span.dropdown-toggle_item");
    public static final By BUTTON_CREATE_USER = By.xpath("//div[text()='Ввести данные']");
    public static final By BUTTON_SAVE_USER = By.cssSelector("button:nth-child(1)");
    public static final By BUTTON_DELETE_USER = By.cssSelector(".icon.icon-web-general.icons-general-delete");
    public static final By BUTTON_DELETE_ALL_USERS = By.cssSelector("a.toolbar_button:nth-child(1)");
    public static final By BUTTON_GROUP_OPER_DELETE_USERS = By.xpath("//a[text()='Удалить пользователей']");
    public static final By CHECKBOX_SELECT_ALL_USERS = By.cssSelector("th.user-list_first-column.table_header");
    public static final By FIELD_ERROR_USER = By.cssSelector(".form_field-error");
    public static final By TITLE_USER_FORM = By.cssSelector("div.header");
    public static final By FIELD_USER_NAME = By.cssSelector("[formcontrolname='name'] input");
    public static final By FIELD_USER_EMAIL = By.cssSelector("[formcontrolname='email'] input");
    public static final By FIELD_USER_PHONE = By.cssSelector("[formcontrolname='phone'] input");
    public static final By FIELD_USER_ABOUT = By.cssSelector("textarea");
}

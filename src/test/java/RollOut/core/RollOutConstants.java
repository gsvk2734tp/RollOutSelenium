package RollOut.core;

import org.openqa.selenium.By;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Класс с константами для RollOut
 */

public class RollOutConstants {
    //ССылки
    public static final String URL_NSMS_SITE = "http://rollout.nsms.site/organizations";
    public static final String URL_NSMS_USERS = "http://rollout.nsms.site/users";
    public static final String URL_NSMS_SITE_TEST = "http://rollout-test.nsms.site";
    public static final String URL_NSMS_USERS_TEST = "http://rollout-test.nsms.site/users";
    public static final String URL_WINDOWS_SITE = "https://10.0.15.237:8090";
    public static final String URL_WINDOWS_USERS = "https://10.0.15.237:8090/users";
    public static final String URL_WINDOWS_AUTH = "https://10.0.15.237:8811";
    public static final String URL_IDENTITY_NSMS = "https://identity.nsms.site/account/login";

    //Общие константы
    public static final String SPEC_SYMBOLS = "!#$%&'*+-/=?^_`{|";
    public static final String TITLE_APP = "Rollout.WebApplication";
    public static final By BUTTON_DELETE_PRESS_YES_USER_AND_ORG = By.cssSelector("button.actions_button:nth-child(1)");
    public static final By SELECT_LANGUAGE_AUTH = By.cssSelector(".language-dropdown-toggle-text");
    static final By LOGO = By.className("logo");
    static final By LOGO_VIPNET = By.xpath("//span[text()='ViPNet']");
    static final By LOGO_NSMS = By.xpath("//span[text()='Network Security Management System']");

    //Страницы авторизации
    public static final String TITLE_SILSO = "ViPNet Network Security Management System";
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "123123123";
    public static final By NAME_FIElD = By.id("UserName");
    public static final By PASSWORD_FIELD = By.id("Password");
    public static final By LOGIN_BUTTON = By.cssSelector("button.btn-login");

    //Страница организации
    public static final By BUTTON_EDIT_ORG = By.cssSelector("tr.active i.table_edit-row-icon");
    public static final By BUTTON_DELETE_ORG = By.cssSelector("tr.active i.table_delete-row-icon");
    public static final By BUTTON_CANCEL_ORG = By.cssSelector("button:nth-child(2)");
    public static final By BUTTON_ADD_ORG = By.cssSelector("a.toolbar_button");
    public static final By BUTTON_SAVE_ORG = By.cssSelector("button.actions_button");
    public static final By DROPDOWN_SELECT_ORG = By.cssSelector("span.ng-option-label");
    public static final By FIELD_URI_ORG = By.cssSelector("input.content_field-text-input");
    public static final By FIELD_NAME_ORG = By.cssSelector(".ng-input.ng-star-inserted input");
    public static final By ORG_CURRENT_NAME = By.cssSelector(".ng-value-label");
    public static final By FIELD_ERROR_ORG = By.cssSelector(".error.ng-star-inserted");

    //Страница пользователи
    public static final By BUTTON_ADD_USER = By.cssSelector("a.toolbar_button");
    public static final By BUTTON_SAVE_USER = By.cssSelector("button:nth-child(1)");
    public static final By BUTTON_DELETE_USER = By.cssSelector(".icon.icon-web-general.icons-general-delete");
    public static final By BUTTON_DELETE_ALL_USERS = By.cssSelector("a.toolbar_button:nth-child(1)");
    public static final By BUTTON_GROUP_OPER_DELETE_USERS = By.xpath("//a[text()='Удалить пользователей']");
    public static final By CHECKBOX_SELECT_ALL_USERS = By.cssSelector("th.user-list_first-column.table_header");
    public static final By FIELD_ERROR_USER = By.cssSelector(".form_field-error");
    public static final By TITLE_USER_FORM = By.cssSelector("span.header_title");
    public static final By FIELD_USER_NAME = By.cssSelector("[formcontrolname='name'] input");
    public static final By FIELD_USER_EMAIL = By.cssSelector("[formcontrolname='email'] input");
    public static final By FIELD_USER_PHONE = By.cssSelector("[formcontrolname='phone'] input");
    public static final By FIELD_USER_ABOUT = By.cssSelector("textarea");
}

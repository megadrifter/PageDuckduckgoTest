package com.github.megadrifter.pageduckduckgotest.pages.Duckduckgo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.allurehelper.ParamsHelper;
import ru.sbtqa.tag.allurehelper.Type;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import com.github.megadrifter.pageduckduckgotest.pages.Duckduckgo.ResultsPage;
import ru.sbtqa.tag.pagefactory.extensions.DriverExtension;
import ru.sbtqa.tag.pagefactory.support.ScreenShooter;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * 
 */
@PageEntry(title = "Главная страница")
public class SearchPage extends Page {

    @ElementTitle("Найти")
    @FindBy(id = "search_form_input_homepage")
    public TextInput search;

    @ElementTitle("Меню")
    @FindBy(xpath = "//a[contains(@class,'header__button--menu')]")
    public Button menuButton;

    @ElementTitle("кнопка черная тема")
    @FindBy(xpath = "//li/span/span[contains(@style, 'background-color:#222')]/../..")
    public WebElement blackThemeButton;



    @ElementTitle("Поиск")
    @FindBy(id = "search_button_homepage")
    @RedirectsTo(page = ResultsPage.class)
    public Button searchLoupe;

    public SearchPage(){
        PageFactory.initElements(new HtmlElementDecorator(
                new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("ищет")
    public void startSearching(String searchText){
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);
        ;
    }

    @ActionTitle("применяет черную тему оформления")
    public void setBlackTheme(){
        menuButton.click();
//        (new WebDriverWait(PageFactory.getDriver(), 15)).until(ExpectedConditions.visibilityOfElementLocated(By.("nav-menu--slideout is-open")));
        DriverExtension.waitUntilElementPresent(blackThemeButton,10);
        blackThemeButton.click();
        ParamsHelper.addAttachment(ScreenShooter.take(), "Результат применения черной темы", Type.PNG);
    }
}

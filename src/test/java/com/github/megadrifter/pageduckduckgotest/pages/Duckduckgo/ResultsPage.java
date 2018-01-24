package com.github.megadrifter.pageduckduckgotest.pages.Duckduckgo;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * 
 */
@PageEntry(title = "Результаты поиска")
public class ResultsPage extends Page {

    @ElementTitle("Результаты поиска")
    @FindBy(xpath = "//div[@id='links']//h2//a")
    private List<Link> results;

    public ResultsPage(){
        PageFactory.initElements(new HtmlElementDecorator(
                new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("количество результатов поиска должно быть не равно нулю")
    public void checkResultCount(){
        int resultCount = 0;
        Assert.assertNotEquals("Zero count of search results", resultCount, results.size());
    }
}

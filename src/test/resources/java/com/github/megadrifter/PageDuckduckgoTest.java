package com.github.megadrifter;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;

public class PageDuckduckgoTest {


    private WebDriver driver;


    @Before
    public void Setup(){

    }

    @Test
    public void searchResultsTest(){
        dummyStep();
    }


    @Description("Тест 1 = 1")
    @Step
    private void dummyStep(){
        System.out.println(12345);
        assertEquals(1,1);
    }

}

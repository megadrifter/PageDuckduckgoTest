package com.github.megadrifter.pageduckduckgotest;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.cucumber.TagCucumber;

/**
 * @author sbt-sentsov-aa
 */
@RunWith(TagCucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty"},
        glue = {"ru.sbtqa.tag.pagefactory.stepdefs", "com.github.megadrifter.pageduckduckgotest.stepdefs"},
        features = {"src/test/resources/features/"})

public class CucumberTest {
}
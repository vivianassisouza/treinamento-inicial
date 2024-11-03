package org.nttdata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenGoogleTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void acessarGoogle(){

        driver.get("https://google.com.br");
        Assertions.assertEquals("https://www.google.com.br/", driver.getCurrentUrl());
    }
}

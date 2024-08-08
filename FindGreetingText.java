package com.example.greeting

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindGreetingText {

    @Test
    public void testGreetingMessage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost:3000");
            WebElement h1TagElement = driver.findElement(By.tagName("h1"));
            String h1TextValue = h1TagElement.getText();
            assertEquals("Hello from backend!", h1TextValue);
        } finally {
            driver.quit();
        }
    }
}
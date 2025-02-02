package org.example.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility extends Utility {
    // Private method to find the dropdown element and return a Select instance
    private static Select findByDropDown(By locator) {
        return new Select(driver.findElement(locator));
    }

    // Method to select an option in the dropdown by visible text
    public static void selectByVisibleText(By locator, String text) {

        findByDropDown(locator).selectByVisibleText(text);
    }
}

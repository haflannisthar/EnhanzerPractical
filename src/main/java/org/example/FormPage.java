package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Utility.DropdownUtility.selectByVisibleText;
import static org.example.Utility.JavaScriptUtility.clickJS;
import static org.example.Utility.JavaScriptUtility.scrollToElementJs;
import static org.example.Utility.WaitUtility.fluentWaitUntilVisible;

public class FormPage extends BasePage {

    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailFieldId = By.id("userEmail");
    private final By formField = By.id("userForm");
    private final By femaleRadioButton = By.id("gender-radio-2");
    private final By contactNumberField = By.id("userNumber");

    private final By subjectsContainer = By.id("subjectsContainer");

    private final By sportsHobbyCheckBox = By.id("hobbies-checkbox-1");
    private final By musicHobbyCheckBox = By.id("hobbies-checkbox-3");
    private final By uploadPictureField = By.id("uploadPicture");
    private final By currentAddressField = By.id("currentAddress");
    private final By stateSelectField = By.id("state");
    private final By citySelectField = By.id("city");
    private final By submitButton = By.id("submit");

    // Locators for various elements in the date picker
    private final By selectDateField = By.id("dateOfBirthInput");
    private final By monthDropDown = By.className("react-datepicker__month-select");
    private final By yearDropDown = By.cssSelector(".react-datepicker__year-select");

    private final By modalText=By.id("example-modal-sizes-title-lg");

    private final By modalTableEmailDataTd = By.xpath("//table[contains(@class,'table-dark')]/tbody/tr[2]/td[2]");


    public String invalidEmailFormatValidation() {

        fluentWaitUntilVisible(firstNameField, 30);
        scrollToElementJs(firstNameField);
        set(firstNameField, "Haflan");
        set(lastNameField, "Mumbai");

        scrollToElementJs(emailFieldId);
        set(emailFieldId, "haflan395hmail.com");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scrollToElementJs(submitButton);
        click(submitButton);

        scrollToElementJs(emailFieldId);

        System.out.println("email field color is : " + find(emailFieldId).getCssValue("border-top-color"));


        return find(emailFieldId).getCssValue("border-top-color");


    }


    public int validateRequiredFields() {
        fluentWaitUntilVisible(firstNameField, 30);
        scrollToElementJs(submitButton);
        click(submitButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        get the web element which is text  input or select or textArea
        List<WebElement> formFields = driver.findElements(By.cssSelector("input:not([type='radio']):not([type='checkbox']), select, textarea"));

        int redBorderCount = 0;
        for (WebElement field : formFields) {
//            check the input field border changes to red by getting by css value and compare with it
            String borderColor = field.getCssValue("border-top-color");
// Check if text turns red
            if (borderColor.equals("rgba(220, 53, 69, 1)")) {
                redBorderCount++;
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        get the label element by class (get the radio and checkbox labels)
//        handle radio button and checkbox separately by counting only one per group
        List<WebElement> formLabels = driver.findElements(By.cssSelector(".custom-control-label"));
//
        boolean radioGroupHasError = false;

        for (WebElement label : formLabels) {
            String labelTextColor = label.getCssValue("color");

            // Check if text turns red
            if (labelTextColor.equals("rgba(220, 53, 69, 1)")) {
                // Check if text turns red
                radioGroupHasError = true;
            }
        }

        if (radioGroupHasError) {
            redBorderCount++;
        }

        System.out.println("red border count : " + redBorderCount);

        return redBorderCount;
    }

    public boolean fillRequiredFieldsAndSubmit() throws InterruptedException {

        fluentWaitUntilVisible(firstNameField, 30);
        scrollToElementJs(firstNameField);
        set(firstNameField, "Haflan");
        set(lastNameField, "Mohamed");

        scrollToElementJs(emailFieldId);
        set(emailFieldId, "haflan395@hmail.com");


        scrollToElementJs(femaleRadioButton);
        clickJS(femaleRadioButton);

        set(contactNumberField, "0777123456");





       click(subjectsContainer);
//        set(subjectsContainer, "Maths");
        find(subjectsContainer).sendKeys("Maths");
        find(subjectsContainer).sendKeys(Keys.ENTER);

        scrollToElementJs(sportsHobbyCheckBox); // Scroll to the sports checkbox
        clickJS(sportsHobbyCheckBox);

        scrollToElementJs(musicHobbyCheckBox); // Scroll to the sports checkbox
        clickJS(musicHobbyCheckBox);

        String imagePath = "C:\\Users\\Pc\\Downloads\\testimonial-one-img-1.e88e1b8d.png";

        scrollToElementJs(uploadPictureField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fileInput = find(uploadPictureField);
        js.executeScript("arguments[0].style.display='block';", fileInput);
        fileInput.sendKeys(imagePath);


        Thread.sleep(2000);

        scrollToElementJs(currentAddressField);
        click(currentAddressField);
        set(currentAddressField, "Colombo");

        scrollToElementJs(stateSelectField);
        click(stateSelectField);
        set(stateSelectField, "NCR");
        clickJS(stateSelectField);

        Thread.sleep(1000);

        click(citySelectField);
        set(citySelectField, "Delhi");
        clickJS(citySelectField);

        scrollToElementJs(submitButton);
        click(submitButton);

        Thread.sleep(2000);
        find(modalText).getText();

        System.out.println(find(modalText).getText());

       return find(modalText).isDisplayed();

    }

    public void SelectDate(){
        scrollToElementJs(selectDateField);
        click(selectDateField);

        String day = "16";

        click(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')][text()='" + day + "']"));

        selectByVisibleText(monthDropDown, "October");
        selectByVisibleText(yearDropDown, "2001");
    }




}

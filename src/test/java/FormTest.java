import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest{

    @Test
    public void formInvalidEmailTest(){
      String actualResult=formPage.invalidEmailFormatValidation();
        System.out.println(actualResult);

// check whether the border color of the email field and this are  same ()
      Assert.assertEquals(actualResult,"rgba(220, 53, 69, 1)","Actual and expected results do not match");
    }


//    click on form submit and required fields will turn red
//    get all elements and then get the color (border color, label color) and check them with red
//    then count them  (radio buttons , checkbox will get counted as one )
    @Test
    public void testFormSubmissionWithEmptyFields(){
     int count=formPage.validateRequiredFields();
        System.out.println("Number of required fields with red border: " + count);

        // Assuming there are 3 required fields
        Assert.assertEquals(count, 4, "Expected number of fields with red border do not match");

    }

    @Test
    public void fillAllFieldsAndSubmitTest() throws InterruptedException {
       boolean actual=formPage.fillRequiredFieldsAndSubmit();
       Assert.assertTrue(actual,"Actual and expected results do not match");
    }
   @Test
    public  void selectDate(){
        formPage.SelectDate();
}


}

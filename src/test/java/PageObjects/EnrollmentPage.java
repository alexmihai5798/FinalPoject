package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnrollmentPage {

    @FindBy (xpath = "//*[@id=\"firstName\"]")
    private WebElement firstName;

    @FindBy (xpath = "//*[@id=\"lastName\"]")
    private WebElement lastName;

    @FindBy (xpath = "//*[@id=\"username\"]")
    private WebElement userName;

    @FindBy (xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy (xpath = "//*[@id=\"cpassword\"]")
    private WebElement confirmPassword;

    @FindBy (xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy (xpath = "//*[@id=\"phone\"]")
    private WebElement phone;

    @FindBy (xpath = "//*[@id=\"country\"]")
    private WebElement country;

    @FindBy (xpath = "//*[@id=\"city\"]")
    private WebElement city;

    @FindBy (xpath = "//*[@id=\"postCode\"]")
    private WebElement postalCode;

    @FindBy (xpath = "//*[@id=\"flexRadioButton1\"]")
    private WebElement manualTesterCheckBox;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement nextButton;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[4]/div[2]/input")
    private WebElement cardHolderName;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[1]/input")
    private WebElement cardNumber;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[2]/input")
    private WebElement cardCvc;

    @FindBy (xpath = "//*[@id=\"month\"]/option[7]")
    private WebElement cardMonth;

    @FindBy (xpath = "//*[@id=\"year\"]/option[4]")
    private WebElement cardYear;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement personalInfoNextButton;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement contactInfoNextButton;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement courseOptionsNextButton;

    @FindBy (xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/button[2]")
    private WebElement paymentInfoNextButton;


    public void clickOnNextButton() {this.nextButton.click();}

    public void clickOnPersonalInfoNextButton() {this.personalInfoNextButton.click();}

    public void clickOnContactInfoNextButton() {this.contactInfoNextButton.click();}

    public void clickOnManualTesterCheckBox() {this.manualTesterCheckBox.click();}

    public void clickOnCourseOptionsNextButton() {this.courseOptionsNextButton.click();}

    public void clickOnPaymentInfoNextButton() {this.paymentInfoNextButton.click();}

    public void clickOnCardMonth() {this.cardMonth.click();}

    public void clickOnCardYear() {this.cardYear.click();}

    public EnrollmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this); }

    public void fillInPersonalInformation() {
        firstName.sendKeys("Test");
        lastName.sendKeys("Test");
        userName.sendKeys("testing");
        password.sendKeys("password");
        confirmPassword.sendKeys("password");
    }

    public void fillInContactInformation() {
        email.sendKeys("testing@test.com");
        phone.sendKeys("0770123123");
        country.sendKeys("Romania");
        city.sendKeys("Brasov");
        postalCode.sendKeys("500123");
    }

    public void fillInPaymentInformation() {
        cardHolderName.sendKeys("Alex Mihai");
        cardNumber.sendKeys("1234-1234-1234-1234");
        cardCvc.sendKeys("123");
    }
}

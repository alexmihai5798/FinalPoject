package org.example;

import PageObjects.EnrollmentPage;
import PageObjects.WebsiteMainPage;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class StepDefinitions {

    private final WebDriver driver = new ChromeDriver();

    private WebsiteMainPage mainPage;
    private EnrollmentPage enrollmentPage;

    public StepDefinitions() {
        driver.manage().window().maximize();
        mainPage = new WebsiteMainPage(driver);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        driver.get("file:///C:/Users/Alex/Desktop/curs/Testing-Env-master/index.html");
    }

    @When("I press Start enrollment button")
    public void i_press_start_enrollment_button() {
        mainPage.clickOnEnrollmentButton();
    }

    @Then("it start the {string}")
    public void it_start_the_enrollment(String string) {
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith(string));
    }

    @When("I press read more button")
    public void i_press_read_more_button() {
        Utils.scrollToElement(driver, mainPage.getVirtualHeaderElement());
        mainPage.clickOnReadMoreButton();
    }

    @Then("it takes me to read more page")
    public void it_takes_me_to_read_more_page() {}

    public StepDefinitions(WebDriver driver) {
        mainPage = new WebsiteMainPage(driver);
        PageFactory.initElements(driver, this);
    }

    @When("I introduce {string}")
    public void i_introduce_a_valid_email(String string) {
        mainPage.inputEmail(string);
    }

    @Then("a pop-up confirm the subscription")
    public void a_pop_up_confirm_the_subscription() {
        Assert.assertTrue(driver.switchTo().alert().getText().startsWith("Email saved - you will now receive our monthly newsletter. Thank you!"));
    }

    @Given("I am on the instructor section")
    public void i_am_on_the_instructor_section() {
        driver.get("file:///C:/Users/Alex/Desktop/curs/Testing-Env-master/index.html");
        Utils.scrollToElement(driver, mainPage.getScrollToInstructors());
    }

    @When("I press twitter button")
    public void i_press_twitter_button() {
        mainPage.clickOnTwitterButton();
    }

    @Then("It takes me to the {string} page")
    public void it_takes_me_to_the_page(String string) {
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith(string));
    }

    @When("I press facebook button")
    public void i_press_facebook_button() {
        mainPage.clickOnFacebookButton();
    }

    @When("I press linkedin button")
    public void i_press_linkedin_button() {
        mainPage.clickOnLinkedInButton();
    }

    @When("I press the instagram button")
    public void i_press_the_instagram_button() {
        mainPage.clickOnInstagramButton();
    }

    @Given("I am on the FAQ section")
    public void i_am_on_the_faq_section() {
        driver.get("file:///C:/Users/Alex/Desktop/curs/Testing-Env-master/index.html");
        Utils.scrollToElement(driver, mainPage.getScrollToFirstAccordion());
    }

    @When("I press on first accordion")
    public void i_press_on_first_accordion() {
        mainPage.clickOnFirstAccordion();
    }

    @Then("It have to collapse")
    public void it_have_to_collapse() {
        driver.findElement(By.cssSelector(".accordion-button:not(.collapsed)"));
    }

    @Given("I am on the bottom of the main page")
    public void i_am_on_the_bottom_of_the_main_page() {
        driver.get("file:///C:/Users/Alex/Desktop/curs/Testing-Env-master/index.html");
        Utils.scrollToElement(driver, mainPage.getScrollToTheBottom());
    }

    @When("I press the arrow from lower corner")
    public void i_press_the_arrow_from_lower_corner() {
        mainPage.clickToTheTopButton();
    }

    @Then("It have to scroll up to the main page")
    public void it_have_to_scroll_up_to_the_main_page() {
    }

    @Then("the email box should be red")
    public void the_email_box_should_be_red() {
        driver.findElement(By.cssSelector(".error")); }

    @When("I press read more button from virtual section")
    public void i_press_read_more_button_from_virtual_section() {
        Utils.scrollToElement(driver, mainPage.getScrollToVirtualBox());
        mainPage.clickVirtualReadMoreButton();
    }
    @Then("the page title should start with {string}")
    public void the_page_title_should_start_with(String string) {
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith(string));
    }

    @Given("I am on the sign up page")
    public void i_am_on_the_sign_up_page() {
        driver.get("file:///C:/Users/Alex/Desktop/Testing%20Env/Testing-Env/routes/enrollment.html");
    }
    @When("I introduce the required data")
    public void i_introduce_the_required_data() {
        enrollmentPage.fillInPersonalInformation();
    }

    @When("I press next button")
    public void i_press_next_button() {
        enrollmentPage.clickOnPersonalInfoNextButton();
    }

    @Then("we should be taken to the contact information section")
    public void we_should_be_taken_to_the_contact_information_section() {
        Assert.assertTrue(driver.getPageSource().contains("Contact information"));
    }

    @Given("I am on the contact information section")
    public void i_am_on_the_contact_information_section() {
        driver.get("file:///C:/Users/Alex/Desktop/Testing%20Env/Testing-Env/routes/enrollment.html");
        enrollmentPage.fillInPersonalInformation();
        enrollmentPage.clickOnNextButton();
    }

    @When("I introduce the required information")
    public void i_introduce_the_required_information() {
        enrollmentPage.fillInContactInformation();
    }

    @When("I press next button from the contact information section")
    public void i_press_next_button_from_the_contact_information_section() {
        enrollmentPage.clickOnContactInfoNextButton();
    }

    @Then("we should be taken to the course options")
    public void we_should_be_taken_to_the_course_options() {
        Assert.assertTrue(driver.getPageSource().contains("Course options"));
    }

    @Given("I am on the course options section")
    public void i_am_on_the_course_options_section() {
        driver.get("file:///C:/Users/Alex/Desktop/Testing%20Env/Testing-Env/routes/enrollment.html");
        enrollmentPage.fillInPersonalInformation();
        enrollmentPage.clickOnNextButton();
        enrollmentPage.fillInContactInformation();
        enrollmentPage.clickOnContactInfoNextButton();
    }

    @When("I select Software Testing - Manual tester certificate")
    public void i_select_software_testing_manual_tester_certificate() {
        enrollmentPage.clickOnManualTesterCheckBox();
    }

    @When("I press next button from the course options")
    public void i_press_next_button_from_the_course_options() {
        enrollmentPage.clickOnCourseOptionsNextButton();
    }

    @Then("we should be taken to the payment information")
    public void we_should_be_taken_to_the_payment_information() {
        Assert.assertTrue(driver.getPageSource().contains("Payment information"));
    }

    @Given("I am on the payment information section")
    public void i_am_on_the_payment_information_section() {
        driver.get("file:///C:/Users/Alex/Desktop/Testing%20Env/Testing-Env/routes/enrollment.html");
        enrollmentPage.fillInPersonalInformation();
        enrollmentPage.clickOnNextButton();
        enrollmentPage.fillInContactInformation();
        enrollmentPage.clickOnContactInfoNextButton();
        enrollmentPage.clickOnManualTesterCheckBox();
        enrollmentPage.clickOnCourseOptionsNextButton();
    }
    @When("I introduce the payment data")
    public void i_introduce_the_payment_data() {
        enrollmentPage.fillInPaymentInformation();
    }
    @When("I press next button from payment information")
    public void i_press_next_button_from_payment_information() {
        enrollmentPage.clickOnPaymentInfoNextButton();
    }
    @Then("we should receive a confirmation of the full enrollment process")
    public void we_should_receive_a_confirmation_of_the_full_enrollment_process() {
        Assert.assertTrue(driver.getPageSource().contains("Success!"));
    }

    @Given("I am on the enrollment page")
    public void i_am_on_the_enrollment_page() {
        driver.get("file:///C:/Users/Alex/Desktop/Testing%20Env/Testing-Env/routes/enrollment.html");
    }

    @When("I press next button without introduce data")
    public void iPressNextButtonWithoutIntroduceData() {
        enrollmentPage.clickOnNextButton();
    }

    @Then("an red error message will appear under every data case")
    public void anRedErrorMessageWillAppearUnderEveryDataCase() {
        driver.findElement(By.cssSelector(".error-message"));
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "name");
        }
        driver.quit();
    }

}

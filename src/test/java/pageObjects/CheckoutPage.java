package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    public WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

    }

    final static By _shoppingCartBtn = By.xpath("//span[contains(text(),'Shopping cart')]");
    final static By _goToCartBtn = By.xpath("//button[contains(text(),'Go to cart')]");
    final static By _firstName = By.xpath("//*[@id ='BillingNewAddress_FirstName']");
    final static By _lastName = By.xpath("//*[@id ='BillingNewAddress_LastName']");
    final static By _emailName = By.xpath("//*[@id ='BillingNewAddress_Email']");
    final static By _companyName = By.xpath("//*[@id ='BillingNewAddress_Company']");
    final static By _CountryID = By.xpath("//*[@id='BillingNewAddress_CountryId']");
    //final static By _CountryID = By.xpath("//*[@id='BillingNewAddress_CountryId']/option[20]");

    final static By _stateProvince = By.xpath("//*[@id='BillingNewAddress_StateProvinceId']/option[2]");
    final static By  _city = By.xpath("//*[@id ='BillingNewAddress_City']");
    final static By _firstAddress = By.xpath("//*[@id ='BillingNewAddress_Address1']");
    final static By _lastAddress = By.xpath("//*[@id ='BillingNewAddress_Address2']");
    final static By _zipCode = By.xpath("//*[@id ='BillingNewAddress_ZipPostalCode']");
    final static By  _phoneNumber = By.xpath("//*[@id ='BillingNewAddress_PhoneNumber']");
    final static By  _faxNumber = By.xpath("//*[@id ='BillingNewAddress_FaxNumber']");
    final static By _AddressContinueBtn = By.xpath("//*[@id='billing-buttons-container']/button[4]");
    final static By _shippingMethodContinueBtn = By.xpath("//*[@id='shipping-method-buttons-container']/button");
    final static By _moneyOrder = By.xpath("//*[@id='paymentmethod_2']");
    final static By _paymentInformation = By.xpath("//*[@id='payment-info-buttons-container']/button");
    final static By _confirmOrder = By.xpath("//*[@id='confirm-order-buttons-container']/button");
    final static By orderSuccessfulMSG = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");

    public void miniShoppingCart(){
        driver.findElement(_shoppingCartBtn).click();
    }
    public void gotoCart(){
        driver.findElement(_goToCartBtn).click();
    }
    public void termsConditions(){
       WebElement el = driver.findElement(By.xpath("//*[@id='termsofservice']"));
       el.click();
    }
    public void checkoutButtonClick(){
        WebElement element = driver.findElement(By.xpath("//*[@id='checkout']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

       WebElement el1 = driver.findElement(By.xpath("//*[@id='checkout']"));
       el1.click();
    }

    public void takeInputBillingAdd(String add){
        try {
            Select se = new Select(driver.findElement(By.xpath("//*[@id='billing-address-select']")));
            se.selectByVisibleText(add);
        } catch (NoSuchElementException e) {
            System.out.println("Address type " + add + " not found");
            e.printStackTrace();
        }
    }
    public void firstName(String first){
        driver.findElement(_firstName).sendKeys(first);
    }
    public void lastName(String last){
        driver.findElement(_lastName).sendKeys(last);
    }
    public void emailAddress(String email){
        driver.findElement(_emailName).sendKeys(email);
    }
    public void companyName(String company){
        driver.findElement(_companyName).sendKeys(company);
    }
    public void countrySelect(String country){
        try {
            Select se = new Select(driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']")));
            se.selectByVisibleText(country);
        } catch (NoSuchElementException e) {
            System.out.println("Country type " + country + " not found");
            e.printStackTrace();
        }

    }
    public void stateSelect(String state){
        try {
            Select se = new Select(driver.findElement(By.xpath("//*[@id='BillingNewAddress_StateProvinceId']")));
            se.selectByVisibleText(state);
        } catch (NoSuchElementException e) {
            System.out.println("State type " + state + " not found");
            e.printStackTrace();
        }
    }
    public void cityName(String city){
        driver.findElement(_city).sendKeys(city);
    }
    public void firstAddress(String firstAdd){
        driver.findElement(_firstAddress).sendKeys(firstAdd);
    }
    public void secondAddress(String lastAdd){
        driver.findElement(_lastAddress).sendKeys(lastAdd);
    }
    public void zipCode(String zip){
        driver.findElement(_zipCode).sendKeys(zip);
    }
    public void phoneNumber(String phone){
        driver.findElement(_phoneNumber).sendKeys(phone);
    }
    public void faxNumber(String fax){
        driver.findElement(_faxNumber).sendKeys(fax);
    }
    public void customerAddressContinueButton(){
        driver.findElement(_AddressContinueBtn).click();
    }
    public void groundRadioButton(){
        driver.findElement(By.xpath("//*[@id='shippingoption_0']")).click();
    }
    public void shippingMethodContinueButton(){
        driver.findElement(_shippingMethodContinueBtn).click();

    }
    public void moneyOrderButton(){
        driver.findElement(_moneyOrder).click();
    }
    public void paymentMethodContinueButton(){
        driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/button")).click();
    }
    public void paymentInformationContinueButton(){
        driver.findElement(_paymentInformation).click();
    }
    public void confirmOrderButton(){
        driver.findElement(_confirmOrder).click();
    }
    public String confirmOrderSuccessfulPage(){
        return driver.findElement(orderSuccessfulMSG).getText();
    }

}
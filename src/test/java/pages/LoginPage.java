package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}

	@FindBy(id="txtUserName")WebElement UserName;	
	@FindBy(id="txtPassword")WebElement Password;
	@FindBy(id="btnLogin")WebElement LoginBtn;
	@FindBy(xpath="//a[text()='Forgot Password']")WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//div[contains(@class,'wm-outer-div')]")WebElement WelcomeGTZBetaPopup;
	@FindBy(xpath="//div[contains(@class,'wm-outer-div')]//div[contains(@class,'wm-close-button')]")WebElement WalkmeCloseButton;
	
	By UserProfileImage = By.xpath("//div[@class='user_img_div']");
	
	public void loginToApplication(String User, String Pwd)
	{
		UserName.sendKeys(User);
		Password.sendKeys(Pwd);
		LoginBtn.click();
	}

	public void VerifyLogin() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOf(WelcomeGTZBetaPopup));
		
		if(WelcomeGTZBetaPopup.isDisplayed())
		{WalkmeCloseButton.click();}	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(UserProfileImage));
		
		Thread.sleep(5000);
	}

	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportRolePage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public SupportRolePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}

	//Menus
	@FindBy(xpath="//*[@class= 'side_panel']//following :: div[contains(@class,'nav_ul')]//following :: a[contains(text(),'System Admin')]/parent:: div")WebElement SystemAdmin_MainMenu;	
	@FindBy(xpath="//div[contains(@class,'nav_ul')]//following :: *[@class = 'sub_menu_list'] //following-sibling :: a[contains(text(),'System Roles')]")WebElement SystemRoles_SubMenu;	
	@FindBy(xpath="//div[contains(@class,'nav_ul')]//following :: *[@class = 'sub_menu_list'] //following-sibling :: a[contains(text(),'Support Roles')]")WebElement SupportRoles_SubMenu;
	
	//Actors
	@FindBy(xpath="//div[contains(text(),'Eligible Actors')]") WebElement EligibleActor_Div;
	@FindBy(xpath="//div[contains(text(),'Eligible Actors')]//following::div[@class='multiSelectBtnSection']/following :: div[contains(text(),'Conditional')]")WebElement Actor_Conditional;
	
	
	
	public void NavigateToSupportPage()
	{
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(SystemAdmin_MainMenu));
		
		if(SystemAdmin_MainMenu.isDisplayed())
		{
			Actions hoverOnMenu = new Actions(driver);
			hoverOnMenu.moveToElement(SystemAdmin_MainMenu).moveToElement(SupportRoles_SubMenu).click().build().perform();
		}	
		
				
	}
}

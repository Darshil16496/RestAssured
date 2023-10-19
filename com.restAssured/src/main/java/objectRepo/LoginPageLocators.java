package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {

	@FindBy(id="usernmae")
	private WebElement username;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signin;
	
	public LoginPageLocators(WebDriver cd) {
		PageFactory.initElements(cd, this);
	}
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignin() {
		return signin;
	}
	
	public void setUsername(WebElement username) {
		this.username = username;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setSignin(WebElement signin) {
		this.signin = signin;
	}
	
	public void loginactions(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		signin.click();
	}

}

package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocator {

	
	
	@FindBy(xpath="//a[text()='Projects']")
	private WebElement projects;
	
	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement createproject;
	
	public HomePageLocator(WebDriver cd) {
		PageFactory.initElements(cd, this);
	}
	
	
	public WebElement getProjects() {
		return projects;
	}

	public WebElement getCreateproject() {
		return createproject;
	}


	public void setProjects(WebElement projects) {
		this.projects = projects;
	}

	public void setCreateproject(WebElement createproject) {
		this.createproject = createproject;
	}

	
	public void homeActions() {
		projects.click();
		
	}
	
	public void createProjectClick() {
		createproject.click();
	}
	
	
	
	
}

package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectLocators {

	
	@FindBy(name = "projectName")
	private WebElement projectname;
	
	@FindBy(name = "createdBy")
	private WebElement createby;
	
	@FindBy(xpath = "//input[@value='Add Project']")
	private WebElement addproject;
	
	public CreateProjectLocators(WebDriver cd) {
		PageFactory.initElements(cd, this);
	}
	
	public WebElement getProjectname() {
		return projectname;
	}

	public WebElement getCreateby() {
		return createby;
	}

	public WebElement getAddproject() {
		return addproject;
	}
	
	public void setProjectname(WebElement projectname) {
		this.projectname = projectname;
	}

	public void setCreateby(WebElement createby) {
		this.createby = createby;
	}

	public void setAddproject(WebElement addproject) {
		this.addproject = addproject;
	}

	public void createProject(String projectName, String createBy) {
		projectname.sendKeys(projectName);
		createby.sendKeys(createBy);
		addproject.click();
	}
}

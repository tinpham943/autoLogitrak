package com.tc911.common.element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tc911.common.core.BasePageObject;

public class Login extends BasePageObject {

	//========== Login Page ==========
	@FindBy(css = "#txtUsername")
	private WebElement userId;

	@FindBy(css = "#passWord")
	private WebElement passWord;

	@FindBy(css= "#LoginForm_button_submit")
	private WebElement submit;

	@FindBy(css = "#action")
	private WebElement action ;
	@FindBy(css = "#treeView")
	private WebElement treeView;
	@FindBy(css = "#browser")
	private WebElement browser;
	@FindBy(css = "#operatingSystem")
	private WebElement operatingSystem ;
	@FindBy(css = "#loginType")
	private WebElement loginType;

	@FindBy(css= "ul.errorMessage>li>span>b")
	private WebElement error;

	// Constructor
	public Login(String browser) {
		super(browser);
	}

	public Login typeUsername(String username) {
		userId.sendKeys(username);
		return this;
	}

	public Login typePassword(String password) {
		passWord.sendKeys(password);
		return this;
	}

	public void submit() {
		passWord.sendKeys(Keys.ENTER);
	}

	public String traceError(){
		return error.getText();
	}
}

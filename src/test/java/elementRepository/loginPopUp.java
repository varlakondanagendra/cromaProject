package elementRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPopUp {
 @FindBy(xpath="//input[@placeholder='Enter your Email ID or phone number']")
 private WebElement UserNameTextfieldInLoginPopUp;
 @FindBy (xpath = "//small[contains(text(),'Please enter your Email ID or Phone number')]")
 private WebElement TitleOfThePageInLogInPopOu;
 @FindBy(xpath = "//button[contains(text(),'Continue')]")
 private WebElement ContinueButtonInLoginPopUp;
 @FindBy(xpath =" //span[text()='Keep me signed in']/../../span")
 private WebElement KeepMeSignedInCheckBox;
 @FindBy(xpath = "//span[text()='Create Account']")
 private WebElement CreateAccountText;
public WebElement getUserNameTextfieldInLoginPopUp() {
	return UserNameTextfieldInLoginPopUp;
}
public void setUserNameTextfieldInLoginPopUp(WebElement userNameTextfieldInLoginPopUp) {
	UserNameTextfieldInLoginPopUp = userNameTextfieldInLoginPopUp;
}
public WebElement getTitleOfThePageInLogInPopOu() {
	return TitleOfThePageInLogInPopOu;
}
public void setTitleOfThePageInLogInPopOu(WebElement titleOfThePageInLogInPopOu) {
	TitleOfThePageInLogInPopOu = titleOfThePageInLogInPopOu;
}
public WebElement getContinueButtonInLoginPopUp() {
	return ContinueButtonInLoginPopUp;
}
public void setContinueButtonInLoginPopUp(WebElement continueButtonInLoginPopUp) {
	ContinueButtonInLoginPopUp = continueButtonInLoginPopUp;
}
public WebElement getKeepMeSignedInCheckBox() {
	return KeepMeSignedInCheckBox;
}
public void setKeepMeSignedInCheckBox(WebElement keepMeSignedInCheckBox) {
	KeepMeSignedInCheckBox = keepMeSignedInCheckBox;
}
public WebElement getCreateAccountText() {
	return CreateAccountText;
}
public void setCreateAccountText(WebElement createAccountText) {
	CreateAccountText = createAccountText;
}


}

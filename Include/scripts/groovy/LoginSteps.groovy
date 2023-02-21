import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginSteps {
	@Given("user is on login page")
	public void user_is_on_login_page() {

		WebUI.openBrowser('')

		WebUI.navigateToUrl('https://www.saucedemo.com/')
	}

	@When("user enters (.*) and (.*)")
	public void user_enters_username_and_password(String username, String password ) {

		WebUI.click(findTestObject('Login/username'))

		WebUI.setText(findTestObject('Login/username'), username)

		WebUI.click(findTestObject('Login/password'))

		WebUI.setText(findTestObject('Login/password'), password)
	}


	@When("clicks on login button")
	public void clicks_on_login_button() {


		WebUI.click(findTestObject('Login/LoginButton'))
	}


	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {

		//		WebUI.verifyElementText(findTestObject('Object Repository/Homepage/NamePage'), 'PRODUCTS')
		def text = WebUI.getText(findTestObject('Homepage/NamePage'))

		if (text == 'PRODUCTS') {
			println('Login Thành công')
		} else {
			println('Login Không Thành công')
		}

	}


	@When("user input wrong (.*) and (.*)")
	public void user_input_wrong_username_and_password(String username , String password) {

		WebUI.click(findTestObject('Login/username'))

		WebUI.setText(findTestObject('Login/username'), username)

		WebUI.click(findTestObject('Login/password'))

		WebUI.setText(findTestObject('Login/password'), password)
	}

	@Then("there is notifivation worng password")
	public void there_is_notifivation_worng_password() {
		def b =WebUI.getText(findTestObject('Object Repository/Login/worng_notification'))
		if (b=='Epic sadface: Username and password do not match any user in this service') {
			println('trả về thông báo đúng')
		}
		else {
			print('trả về thông báo sai')
		}
	}


	@When("user input (.*) and (.*) has been block")
	public void user_input_username_and_password_has_been_block(String username , String password) {

		WebUI.click(findTestObject('Login/username'))

		WebUI.setText(findTestObject('Login/username'), username)

		WebUI.click(findTestObject('Login/password'))

		WebUI.setText(findTestObject('Login/password'), password)

	}


	@Then("there is notifivation that account has been lock")
	public void there_is_notifivation_that_account_has_been_lock() {
		def b =WebUI.getText(findTestObject('Object Repository/Login/worng_notification'))
		if (b=='Epic sadface: Sorry, this user has been locked out') {
			println('trả về thông báo đúng')
		}
		else {
			print('trả về thông báo sai')

		}

	}

	@Given("user mở trang web tên demo")
	public void user_mở_trang_web_tên_demo() {

		WebUI.openBrowser('')

		WebUI.navigateToUrl('https://www.saucedemo.com/')
	}

	//	@When("khi hệ thống hiển thị trang web user thực hiện nhập thông tin username và password")
	//	public void khi_hệ_thống_hiển_thị_trang_web_user_thực_hiện_nhập_thông_tin_username_và_password() {
	//
	//		WebUI.click(findTestObject('Object Repository/Login1/username'))
	//
	//		WebUI.setText(findTestObject('Object Repository/Login1/username'), 'standard_user')
	//
	//		WebUI.click(findTestObject('Object Repository/Login1/password'))
	//
	//		WebUI.setText(findTestObject('Object Repository/Login1/password'), 'secret_sauce')
	//	}

	//	@When("khi hệ thống hiển thị trang web user thực hiện nhập thông tin (.*) và (.*) vào")
	//	public void khi_hệ_thống_hiển_thị_trang_web_user_thực_hiện_nhập_thông_tin_username_và_password_vào(String username , String password) {
	//
	//		WebUI.click(findTestObject('Object Repository/Login1/username'))
	//
	//		WebUI.setText(findTestObject('Object Repository/Login1/username'), username)
	//
	//		WebUI.click(findTestObject('Object Repository/Login1/password'))
	//
	//		WebUI.setText(findTestObject('Object Repository/Login1/password'), password)
	//
	//	}
	//
	//
	//	@When("Sao khi nhập xong user bấm login")
	//	public void sao_khi_nhập_xong_user_bấm_login() {
	//
	//		WebUI.click(findTestObject('Object Repository/Login1/login_button'))
	//	}
	//
	//	@Then("Sao khi login hệ thống hiển thị trang product")
	//	public void sao_khi_login_hệ_thống_hiển_thị_trang_product() {
	//
	//		def text = WebUI.getText(findTestObject("Object Repository/Login1/text"))
	//
	//		if (text == 'PRODUCTS' ) {
	//			println("đăng nhập thành công")
	//		}else {
	//			println("đăng nhập không thành công")
	//		}
	//
	//		//		WebUI.verifyElementText(findTestObject('Object Repository/Login1/text'), 'PRODUCTS')
	//
	//	}
}
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.click(findTestObject('user/supplier/navigation/a_account'))
WebUI.click(findTestObject('user/supplier/navigation/a_supplier'))
WebUI.click(findTestObject('user/supplier/actions/button_add'))
WebUI.waitForPageLoad(50, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('user/supplier/fields/input_first_name'), FirstName)
WebUI.setText(findTestObject('user/supplier/fields/input_last_name'), LastName)
WebUI.setText(findTestObject('user/supplier/fields/input_email'), Email)
WebUI.setText(findTestObject('user/supplier/fields/input_password'), Password)
WebUI.setText(findTestObject('user/supplier/fields/input_mobile'), MobileNumber)
WebUI.click(findTestObject('user/supplier/fields/div_country_initiate'))
WebUI.setText(findTestObject('user/supplier/fields/input_select_country'), Country)
WebUI.click(findTestObject('user/supplier/fields/div_county_select'))
WebUI.setText(findTestObject('user/supplier/fields/input_address_line1'), AddressLine1)
WebUI.setText(findTestObject('user/supplier/fields/input_address_line2'), AddressLine2)
WebUI.selectOptionByValue(findTestObject('user/supplier/fields/select_apply_for'), SupplierFor, true)
WebUI.setText(findTestObject('user/supplier/fields/input_item_name'), ItemName)
//WebUI.click(findTestObject('user/supplier/fields/ul_select_hotel'))
//WebUI.setText(findTestObject('user/supplier/fields/input_select_hotel'), Hotel)
//WebUI.sendKeys(findTestObject('user/supplier/fields/input_select_hotel'), Keys.chord(Keys.TAB))
//WebUI.click(findTestObject('user/supplier/fields/ul_select_tour'))
//WebUI.setText(findTestObject('user/supplier/fields/input_select_tour'), Tour)
//WebUI.sendKeys(findTestObject('user/supplier/fields/input_select_tour'), Keys.chord(Keys.TAB))
//WebUI.click(findTestObject('user/supplier/fields/ul_select_car'))
//WebUI.setText(findTestObject('user/supplier/fields/input_select_car'), Car)
//WebUI.sendKeys(findTestObject('user/supplier/fields/input_select_car'), Keys.chord(Keys.TAB))

for(int i=1;i<=5;i++) {
	if(CanAdd=='1'){
		WebUI.check(findTestObject('user/supplier/fields/checkbox_all_add',[('value') : i]))
	}
	if(CanEdit=='1'){
		WebUI.check(findTestObject('user/supplier/fields/checkbox_all_edit',[('value') : i]))
	}
	if(CanDelete=='1'){
		WebUI.check(findTestObject('user/supplier/fields/checkbox_all_delete',[('value') : i]))
	}
}
WebUI.click(findTestObject('user/supplier/actions/button_submit'))
WebUI.waitForPageLoad(50, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('user/supplier/fields/created_supplier'), 30)
println("Admin added successfully")



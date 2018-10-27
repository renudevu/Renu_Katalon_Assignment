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

WebUI.openBrowser('')

WebUI.click(findTestObject('user/supplier/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('user/supplier/Page_Dashboard/a_Suppliers'))

WebUI.click(findTestObject('user/supplier/Page_Suppliers Management/button_Add'))

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_fname'), 'saranya')

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_lname'), 'jaya')

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_email'), 'sj@sj.com')

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_password'), 'password1!')

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_mobile'), '8301089507')

WebUI.click(findTestObject('user/supplier/Page_Add Supplier/div_select2-drop-mask'))

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_select2-input select2-fo'), 'indi')

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_address1'), 'Rakendu')

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_address2'), '355')

WebUI.selectOptionByValue(findTestObject('user/supplier/Page_Add Supplier/select_Hotels'), 'Tours', true)

WebUI.setText(findTestObject('user/supplier/Page_Add Supplier/input_itemname'), 'trip')

WebUI.click(findTestObject('user/supplier/Page_Add Supplier/ul_select2-choices'))

WebUI.click(findTestObject('user/supplier/Page_Add Supplier/ul_select2-choices_1'))

WebUI.click(findTestObject('user/supplier/Page_Add Supplier/ul_select2-choices_2'))

WebUI.click(findTestObject('user/supplier/Page_Add Supplier/button_Submit'))

WebUI.closeBrowser()


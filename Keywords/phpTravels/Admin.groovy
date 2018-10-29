package phpTravels

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import jdk.internal.instrumentation.MethodCallInliner.CatchBlock
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

import org.codehaus.groovy.ast.stmt.TryCatchStatement

public enum User {
	Row,
	Id,
	FirstName,
	LastName,
	Email,
	Password,
	Mobile,
	Country,
	Address1,
	Address2,
	Status
}

public enum Permission {
	Row,
	Id,
	UserId,
	AccessArea,
	CanAdd,
	CanEdit,
	CanDelete
}

public class Admin {


	@Keyword
	def NavigateToAdminPage(){
		WebUI.click(findTestObject('user/admin/dashboard/a_account'))
		WebUI.click(findTestObject('user/admin/dashboard/a_admin'))
	}

	@Keyword
	def SetAdminDetails(int userIndex){
		WebUI.click(findTestObject('user/admin/action/button_add'))
		def dbdata= findTestData('userDetail')
		WebUI.setText(findTestObject('user/admin/fields/input_first_name'), dbdata.getValue(User.FirstName.ordinal(),userIndex))
		WebUI.setText(findTestObject('user/admin/fields/input_last_name'), dbdata.getValue(User.LastName.ordinal(),userIndex))
		WebUI.setText(findTestObject('user/admin/fields/input_email_address'),dbdata.getValue(User.Email.ordinal(),userIndex))
		WebUI.setText(findTestObject('user/admin/fields/input_password'), dbdata.getValue(User.Password.ordinal(),userIndex))
		WebUI.setText(findTestObject('user/admin/fields/input_mobile_number'), dbdata.getValue(User.Mobile.ordinal(),userIndex))
		WebUI.click(findTestObject('user/admin/fields/autocomplete_country_control'))
		WebUI.click(findTestObject('user/admin/fields/autocomplete_country_search'))
		WebUI.setText(findTestObject('user/admin/fields/autocomplete_country_search'), dbdata.getValue(User.Country.ordinal(),userIndex))
		WebUI.click(findTestObject('user/admin/fields/autocomplete_country_select'))
		WebUI.setText(findTestObject('user/admin/fields/input_address_line1'), dbdata.getValue(User.Address1.ordinal(),userIndex))
		WebUI.setText(findTestObject('user/admin/fields/input_address_line2'), dbdata.getValue(User.Address2.ordinal(),userIndex))
		WebUI.selectOptionByIndex(findTestObject('user/admin/fields/select_status'),dbdata.getValue(User.Status.ordinal(),userIndex))
	}

	@Keyword
	def ManageAccessDetails () {
		def dbdata= findTestData('userPermission')
		for(int i=1;i<=5;i++) {
			if(dbdata.getValue(Permission.CanAdd.ordinal(),i).intern()=='true'){
				WebUI.check(findTestObject('user/admin/fields/checkbox_all_add',[('value') : i]))
			}
			if(dbdata.getValue(Permission.CanEdit.ordinal(),i).intern()=='true'){
				WebUI.check(findTestObject('user/admin/fields/checkbox_all_edit',[('value') : i]))
			}
			if(dbdata.getValue(Permission.CanDelete.ordinal(),i).intern()=='true'){
				WebUI.check(findTestObject('user/admin/fields/checkbox_all_delete',[('value') : i]))
			}
		}
	}

	@Keyword
	def SaveDetails(){
		WebUI.click(findTestObject('user/admin/action/button_submit'))
		WebUI.waitForPageLoad(50, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('user/admin/fields/created_admin'), 30)
		println("Admin added successfully")
	}

	def DeleteAdmin(){
		WebUI.click(findTestObject('user/admin/action/checkbox_admin'))
		WebUI.click(findTestObject('user/admin/action/button_delete'))
		WebUI.acceptAlert()
		println("Admin deleted successfully")
	}
}

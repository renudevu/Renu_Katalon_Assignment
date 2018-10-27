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
import com.kms.katalon.core.testdata.InternalData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

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

public enum Travel {
	Name,
	Description,
	AdultCount,
	AdultPrice,
	ChildCount,
	ChildPrice,
	InfantCount,
	InfantPrice,
	Star,
	Days,
	Night,
	Type,
	Featured,
	Location,
	Status
}

class Tour {

	public int tourIndex=0;
	public int inclusionIndex=2;

	@Keyword
	def NavigateToTourPage(){
		WebUI.click(findTestObject('tour/navigation/a_tour'))
		WebUI.click(findTestObject('tour/navigation/a_Add'))
	}

	@Keyword
	def SetTourDetails(){
		InternalData data= findTestData('tourDetails')
		WebUI.selectOptionByValue(findTestObject('tour/fields/select_status'), data.internallyGetValue(Travel.Status.ordinal(), tourIndex), true)
		WebUI.setText(findTestObject('tour/fields/input_name'), data.internallyGetValue(Travel.Name.ordinal(), tourIndex))
		WebUI.switchToFrame(findTestObject('tour/fields/iframe_object'), 30)
		WebUI.click(findTestObject('tour/fields/iframe_body'))
		WebUI.setText(findTestObject('tour/fields/iframe_body'), data.internallyGetValue(Travel.Description.ordinal(), tourIndex))
		WebUI.switchToDefaultContent()
		WebUI.setText(findTestObject('tour/fields/input_adult_count'), data.internallyGetValue(Travel.AdultCount.ordinal(), tourIndex))
		WebUI.setText(findTestObject('tour/fields/input_adult_price'), data.internallyGetValue(Travel.AdultPrice.ordinal(), tourIndex))
		WebUI.click(findTestObject('tour/fields/span_enable_child'))
		WebUI.setText(findTestObject('tour/fields/input_child_count'), data.internallyGetValue(Travel.ChildCount.ordinal(), tourIndex))
		WebUI.setText(findTestObject('tour/fields/input_child_price'), data.internallyGetValue(Travel.ChildPrice.ordinal(), tourIndex))
		WebUI.waitForPageLoad(50, FailureHandling.STOP_ON_FAILURE)
		//WebUI.click(findTestObject('tour/fields/span_enable_infants'))
		//WebUI.setText(findTestObject('tour/fields/input_infant_count'), data.internallyGetValue(Travel.InfantCount.ordinal(), tourIndex))
		//WebUI.setText(findTestObject('tour/fields/input_infant_price'), data.internallyGetValue(Travel.InfantPrice.ordinal(), tourIndex))
		WebUI.selectOptionByValue(findTestObject('tour/fields/select_option'), data.internallyGetValue(Travel.Star.ordinal(), tourIndex), true)
		WebUI.setText(findTestObject('tour/fields/input_days'), data.internallyGetValue(Travel.Days.ordinal(), tourIndex))
		WebUI.setText(findTestObject('tour/fields/input_nights'), data.internallyGetValue(Travel.Night.ordinal(), tourIndex))
		WebUI.click(findTestObject('tour/fields/select_type'))
		WebUI.click(findTestObject('tour/fields/select_type_option',[('type') : data.internallyGetValue(Travel.Type.ordinal(), tourIndex)]))
		WebUI.selectOptionByValue(findTestObject('tour/fields/select_featured'), data.internallyGetValue(Travel.Featured.ordinal(), tourIndex), true)
		WebUI.click(findTestObject('tour/fields/autocomplete_location_selector'))
		WebUI.setText(findTestObject('tour/fields/autocomplete_location_control'), data.internallyGetValue(Travel.Location.ordinal(), tourIndex))
		WebUI.click(findTestObject('tour/fields/autocomplete_location_trigger'))
	}

	@Keyword
	def SetTourInclusions(){
		InternalData data= findTestData('tourInclusions')
		WebUI.click(findTestObject('tour/fields/a_inclusion'))
		WebUI.waitForPageLoad(20, FailureHandling.STOP_ON_FAILURE)
		for (int i=4; i<=45;i++) {
			String selectTrigger=data.internallyGetValue("selected",i-4)
			if(selectTrigger.intern()!='1'){
				WebUI.click(findTestObject('tour/fields/checkbox_inclusion', [('value') : i ]))
			}
		}
	}

	@Keyword
	def SetTourExclusions(){
		InternalData data= findTestData('tourExclusions')
		WebUI.click(findTestObject('tour/fields/a_exclusion'))
		WebUI.waitForPageLoad(20, FailureHandling.STOP_ON_FAILURE)
		for (int i=4; i<=17;i++) {
			String selectTrigger=data.internallyGetValue("selected",i-4)
			if(selectTrigger.intern()!='1'){
				WebUI.click(findTestObject('tour/fields/checkbox_exclusion', [('value') : i ]))
			}
		}
	}

	@Keyword
	def SaveTour(){
		WebUI.click(findTestObject('tour/fields/button_submit'))
		WebUI.verifyElementPresent(findTestObject('tour/fields/table_list'), 30)
		println("Tour has been saved Successfully")
	}
}
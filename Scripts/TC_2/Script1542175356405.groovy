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

WebUI.navigateToUrl('https://www.phptravels.net/admin/')

WebUI.setText(findTestObject('Scen2/Page_Administator Login/input_email'), 'sha@yahoo.com')

WebUI.setText(findTestObject('Scen2/Page_Administator Login/input_password'), 'demoadmin1')

WebUI.click(findTestObject('Scen2/Page_Administator Login/button_Login'))

WebUI.click(findTestObject('Scen2/Page_Dashboard/a_Tours'))

WebUI.click(findTestObject('Scen2/Page_Dashboard/a_Tours_1'))

WebUI.click(findTestObject('Scen2/Page_Tours Management/button_Add'))

def tourData = findTestData('TourDetails')

int i = 1

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'tourname']), tourData.getValue(i++, 1))

WebUI.scrollToElement(findTestObject('RepCreation/childBtn'), 10)

WebUI.click(findTestObject('RepCreation/childBtn'))

WebUI.click(findTestObject('RepCreation/infantBtn'))

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'maxadult']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'adultprice']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'maxchild']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'childprice']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'maxinfant']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/GeneralTab', [('General') : 'infantprice']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'tourdays']), tourData.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'tournights']), tourData.getValue(i++, 1))

WebUI.click(findTestObject('RepCreation/ClickStar'))

WebUI.click(findTestObject('RepCreation/Star'))

WebUI.click(findTestObject('RepCreation/TourTypeSelect'))

WebUI.click(findTestObject('RepCreation/TourType', [('type') : tourData.getValue(i++, 1)]))

WebUI.click(findTestObject('RepCreation/LocationClick'))

WebUI.setText(findTestObject('RepCreation/LocationSelect'), 'Paris')

WebUI.click(findTestObject('RepCreation/LocationValueSelect'))

WebUI.click(findTestObject('Scen2/Page_Add Tour/a_Inclusions'))

WebUI.click(findTestObject('RepCreation/IncSelectAll'))

WebUI.click(findTestObject('RepCreation/IncSelectAll'))

def incData = findTestData('Inclusions')

for (def indexnumber : (1..incData.getRowNumbers())) {
    WebUI.click(findTestObject('RepCreation/Inc', [('z') : incData.getValue(1, indexnumber)]))
}

WebUI.click(findTestObject('Scen2/Page_Add Tour/a_Exclusions'))

def excData = findTestData('Exclusion')

for (def indnumber : (1..excData.getRowNumbers())) {
    WebUI.click(findTestObject('RepCreation/ExcOptions', [('ExclusionOption') : excData.getValue(1, indnumber)]))
}

WebUI.click(findTestObject('Scen2/Page_Add Tour/button_Submit'))

not_run: WebUI.closeBrowser()


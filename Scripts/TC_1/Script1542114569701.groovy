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

WebUI.setText(findTestObject('RepCreation/Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('RepCreation/Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('RepCreation/Page_Administator Login/button_Login'))

WebUI.click(findTestObject('RepCreation/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('RepCreation/Page_Dashboard/a_Admins'))

WebUI.click(findTestObject('RepCreation/Page_Admins Management/button_Add'))

WebUI.click(findTestObject('RepCreation/Page_Dashboard/countryDropdown'))

WebUI.click(findTestObject('RepCreation/Page_Dashboard/country'), FailureHandling.STOP_ON_FAILURE)

def dbdata = findTestData('New Test Data')

int i = 1

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'fname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'lname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'email']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'password']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'mobile']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'address1']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'address2']), dbdata.getValue(i++, 1))

def dbCheckbox = findTestData('checkBoxDatafile')

for (def index : (1..dbCheckbox.getRowNumbers())) {
    for (def ind : (1..dbCheckbox.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('RepCreation/dynamicValue', [('x') : dbCheckbox.getValue(ind, index)]), 10)

        WebUI.click(findTestObject('RepCreation/dynamicValue', [('x') : dbCheckbox.getValue(ind, index)]))
    }
}

WebUI.click(findTestObject('RepCreation/Page_Add Admin/Page_Add Admin/button_Submit'))

not_run: WebUI.closeBrowser()


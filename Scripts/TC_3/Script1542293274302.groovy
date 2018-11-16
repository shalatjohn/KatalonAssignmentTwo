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

WebUI.click(findTestObject('SupplierCreation/Page_Administator Login/div_Login Panel'))

WebUI.setText(findTestObject('SupplierCreation/Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('SupplierCreation/Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('SupplierCreation/Page_Administator Login/span_Login'))

WebUI.click(findTestObject('SupplierCreation/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('SupplierCreation/Page_Dashboard/a_Suppliers'))

WebUI.click(findTestObject('SupplierCreation/Page_Suppliers Management/button_Add'))

def supData = findTestData('SupplierDetails')

int a = 1

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'fname']), supData.getValue(a++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'lname']), supData.getValue(a++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'email']), supData.getValue(a++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'password']), supData.getValue(a++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'mobile']), supData.getValue(a++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'address1']), supData.getValue(a++, 1))

WebUI.setText(findTestObject('RepCreation/feilddetails', [('y') : 'address2']), supData.getValue(a++, 1))

WebUI.click(findTestObject('SupplierCreation/Page_Add Supplier (1)/b'))

WebUI.setText(findTestObject('SupplierCreation/Page_Add Supplier (1)/Page_Add Supplier/input_select2-input select2-fo'), 
    'Aus')

WebUI.click(findTestObject('SupplierCreation/SupplierLocation'))

def supCheckbox = findTestData('SupplierCheckBox')

for (def SupIndex : (1..supCheckbox.getRowNumbers())) {
    for (def SupInd : (1..supCheckbox.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('RepCreation/dynamicValue', [('x') : supCheckbox.getValue(SupInd, SupIndex)]), 
            10)

        WebUI.click(findTestObject('RepCreation/dynamicValue', [('x') : supCheckbox.getValue(SupInd, SupIndex)]))
    }
}

not_run: WebUI.selectOptionByValue(findTestObject('SupplierCreation/Page_Add Supplier/select_Hotels'), 'Tours', true)

WebUI.click(findTestObject('SupplierCreation/Page_Add Supplier/button_Submit'))

not_run: WebUI.closeBrowser()


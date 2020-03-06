import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import com.ahmedsoft.utils.DataFactory
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

DataFactory factory = new DataFactory()
JsonSlurper jsonSlurper = new JsonSlurper()

//GET all users
def users = CustomKeywords.'com.ahmedsoft.api.RequestHelper.getAllUsers'()

//Select a random user
def randomIndex = factory.generateRandomNumberBetween(0, users.size)
def randomUser = users.get(randomIndex)
def userId = randomUser['id']
println "Random user id: ${userId}" 

//Generate a random fake data for 'PATCH'
def requestBody = factory.jsonifyFields('name','city')
println requestBody

//send the request
def request = findTestObject('Modify user/modify user', ['id': userId])
request.setBodyContent(new HttpTextBodyContent(requestBody,"UTF-8","application/json"))
def response = WS.sendRequest(request)

//verify
def actualUser = response.getResponseText()
actualUser = jsonSlurper.parseText(actualUser)
println actualUser

WS.verifyElementPropertyValue(response, 'name', actualUser['name'])
WS.verifyElementPropertyValue(response, 'city', actualUser['city'])

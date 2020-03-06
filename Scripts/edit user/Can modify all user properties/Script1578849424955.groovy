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
import com.ahmedsoft.utils.DataFactory
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

DataFactory factory = new DataFactory()
JsonSlurper jsonSlurper = new JsonSlurper()

//return all users
def response = WS.sendRequest(findTestObject('Get Users/get all users'))
def users = jsonSlurper.parseText(response.getResponseText())

//select a random user
def randomIndex = factory.generateRandomNumberBetween(0, users.size)
def randomUser = users[randomIndex]
def randomId = randomUser['id']

//Generate random data for user
def expectedUser = factory.jsonifyUserWithoutId()
println "Random user id: ${randomId}"
println expectedUser

//send the request
def request = findTestObject('Modify user/modify user fields',['id': randomId ])
request.setBodyContent(new HttpTextBodyContent(expectedUser, "UTF-8", "application/json"))
WS.sendRequestAndVerify(request)


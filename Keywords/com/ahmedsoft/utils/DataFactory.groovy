package com.ahmedsoft.utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.codearte.jfairy.Fairy
import io.codearte.jfairy.producer.company.Company
import io.codearte.jfairy.producer.company.CompanyFactory
import io.codearte.jfairy.producer.company.CompanyProperties
import io.codearte.jfairy.producer.company.CompanyProvider
import io.codearte.jfairy.producer.company.CompanyProperties.CompanyProperty
import io.codearte.jfairy.producer.person.PersonProperties
import com.ahmedsoft.models.User
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

public class DataFactory {
	Fairy fairy
	private Random random
	def jsonSlurper = new JsonSlurper()

	public DataFactory() {
		fairy = Fairy.create()
	}

	int generateRandomNumberBetween(min, max) {
		random = new Random()
		random.nextInt(max) + min
	}

	def getName() {
		fairy.person(PersonProperties.female()).fullName
	}

	def getCity() {
		fairy.person(PersonProperties.male()).getAddress().city
	}

	def getAge() {
		fairy.person(PersonProperties.female()).age
	}

	/**
	 * Convert user object to json string
	 * @param instance of user to josnify
	 * @return json string representing user object
	 */
	def jsonifyUser(userObject) {		
		JsonOutput.toJson(userObject)
	}
	
	/**
	 * Generate json string from randomly generated user
	 * @return json string representing user object
	 */
	def jsonifyUser() {		
		JsonOutput.toJson(getUser())
	}
	
	/**
	 * convert user object to json string without 'id' field
	 * @param user object with id
	 * @return json string of user without 'id' field
	 */
	def jsonifyUserWithoutId(user) {
		def stringUser = JsonOutput.toJson(user)
		stringUser = jsonSlurper.parseText(stringUser)
		stringUser.remove('id')
		JsonOutput.toJson(stringUser)
	}
	
	/**
	 * convert user object to json string without 'id' field
	 * @return json string representing user object
	 */
	def jsonifyUserWithoutId() {
		def user = getUser()
		user = JsonOutput.toJson(user)
		user = jsonSlurper.parseText(user)
		user.remove('id')
		JsonOutput.toJson(user)
	}

	/**
	 * generate random user object
	 * @return Instance of User
	 */
	def getUser() {
		User user = new User()
		user.setName(getName())
		user.setAge(getAge())
		user.setCity(getCity())
		user
	}
	
	/**
	 * Convert user fields by name to json string 
	 * @param fields to jsonify
	 * @return json string for the fields
	 */
	def jsonifyFields(...fields) {
		println "fields to update ${fields}"
		
		def user = getUser()
		def stringUser = JsonOutput.toJson(user)
		def mapUser = jsonSlurper.parseText(stringUser)
		mapUser.remove('id')		
		
		def newUser = [:]
		fields.each { field ->
			newUser[field] = user[field]
		}
			
		JsonOutput.toJson(newUser)
	}
}

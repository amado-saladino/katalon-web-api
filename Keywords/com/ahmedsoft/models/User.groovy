package com.ahmedsoft.models

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

public class User {
	private int id
	private String name
	private int age
	private String city

	public int getId() {
		id
	}

	public void setId(int id) {
		this.id=id
	}

	public String getName() {
		name
	}

	public void setName(String name) {
		this.name=name
	}

	public int getAge() {
		age
	}

	public void setAge(int age) {
		this.age=age
	}

	public String getCity() {
		city
	}

	public void setCity(String city) {
		this.city=city
	}

	public boolean equals(Object other) {
		if (other == null) return false
		if (this.is(other)) return true
		if (User != other.getClass()) return false
		if (id != other.id) return false
		if (name != other.name) return false
		true
	}

	public int hashCode(){
		this.getId().hashCode()
	}
}

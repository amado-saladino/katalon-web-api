<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create user</name>
   <tag></tag>
   <elementGuidId>4a60006d-e119-4853-95d4-c5ee9540c561</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;name\&quot;: \&quot;${name}\&quot;,\n   \&quot;age\&quot;: ${age},\n   \&quot;city\&quot;: \&quot;${city}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${url}/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'no name'</defaultValue>
      <description></description>
      <id>c5f6653e-c6e3-4a2e-b842-391d4d5fa40f</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>19499000-6392-43b5-a690-68d92d3889d7</id>
      <masked>false</masked>
      <name>age</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.URL</defaultValue>
      <description></description>
      <id>f315763d-654b-4242-81ae-c97eced02273</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'no city'</defaultValue>
      <description></description>
      <id>e7b6063a-b2d6-46d2-9b9f-e7ecab6be47e</id>
      <masked>false</masked>
      <name>city</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

def jsonSlurper = new JsonSlurper()

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

def requestBodyUser = jsonSlurper.parseText(request.getBodyContent().getText())
WS.verifyResponseStatusCode(response, 201)

def addedUser = jsonSlurper.parseText(response.getResponseText())
addedUser.remove('id')
WS.verifyEqual(requestBodyUser, addedUser)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

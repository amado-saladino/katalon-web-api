<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>modify user fields</name>
   <tag></tag>
   <elementGuidId>d51a161a-ba06-431f-823a-10d7be3014e0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${url}/users/${id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.URL</defaultValue>
      <description></description>
      <id>b2d1a478-16f3-4dde-8968-70ecff14b2ee</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>b4b404d0-4c4c-421f-b06a-a01673d24a7a</id>
      <masked>false</masked>
      <name>id</name>
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
WS.verifyResponseStatusCode(response, 200)

def expectedUser = jsonSlurper.parseText(request.getBodyContent().getText())
def actualUser = jsonSlurper.parseText(response.getResponseText())
actualUser.remove('id')
WS.verifyEqual(actualUser, expectedUser)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

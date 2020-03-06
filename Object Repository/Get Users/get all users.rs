<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>get all users</name>
   <tag></tag>
   <elementGuidId>cff9b739-310e-4900-a246-1ae323826f24</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>http://localhost:3000/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

JsonSlurper jsonSlurper = new JsonSlurper()
RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)

//only for test
//WS.verifyElementPropertyValue(response, '[0].name', 'Ahmed')

def jsonResponse = jsonSlurper.parseText(response.getResponseText())
System.out.println(jsonResponse)

println(&quot;I have ${jsonResponse.size()} users&quot;)

assertThat(jsonResponse.size() > 0).isEqualTo(true)
assertThat(jsonResponse.size()).isGreaterThan(0)
println('The name of the first user is: ')
println( jsonResponse.get(0)['name'] )
 
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

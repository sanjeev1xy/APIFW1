package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.Json;
import org.testing.utilities.JsonVariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC4 
{
	@Test
public void testCase4() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
    String bodyData=Json.loadJsonFile("../API_FW1/src/test/java/org/testing/Payloads/bodyDataForUpdate.json");
    bodyData=JsonVariable.jsonvariablereplacement(bodyData, "id", TC1.responseidValue);
    HTTPMethods HTTP=new HTTPMethods(pr);
	Response res=HTTP.updateRecords(bodyData, "QA_Env_APIStudents_URI", TC1.responseidValue);
	System.out.println("***********TC4*************");
	System.out.println("Status Code is "+res.statusCode());
	System.out.println("Response is "+res.asString());
    
}
}

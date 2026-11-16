package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.Json;
import org.testing.utilities.JsonVariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.RandomData;
import org.testing.utilities.jsonParsing;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC1 
{
	static String responseidValue;
	@Test
public void testCase1() throws IOException 
{
	String bodyData=Json.loadJsonFile("../API_FW1/src/test/java/org/testing/Payloads/bodyData.json");
	//System.out.println(bodyData);
	String randomId=RandomData.random();
	bodyData=JsonVariable.jsonvariablereplacement(bodyData, "id", randomId);
	
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
	HTTPMethods http=new HTTPMethods(pr);
	Response res=http.postMethod(bodyData, "QA_Env_ApiStudents_URI");
	System.out.println("*********************TC1*****************");
	System.out.println("status code is "+res.statusCode());
	System.out.println("response data is "+res.asString());
	responseidValue=jsonParsing.Jsonparse(res.asString(), "id");
}
}



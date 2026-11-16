package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.Json;
import org.testing.utilities.JsonVariable;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.RandomData;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC7 
{
	static String responseidvalue;
	@Test
public void testCase7() throws IOException
{
	String bodyData=Json.loadJsonFile("../API_FW1/src/test/java/org/testing/Payloads/bodyData.json");
	String randomId=RandomData.random();
	bodyData=JsonVariable.jsonvariablereplacement(bodyData, "id", randomId);
	
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
	HTTPMethods http=new HTTPMethods(pr);
		
	
	System.out.println("***************TC7****************");
	for(int i=0;i<20;i++)	
	{
		Response res=http.postMethod(bodyData, "QA_Env_CreateNewRecordInDatabase_URI");
		boolean statuscode=Responsevalidation.methodasperstatuscode(200, res);
		if(statuscode) 
		{
			System.out.println("Status code is "+res.statusCode());
			System.out.println("response data is "+res.asString());
			break;
		}
		else 
		{
			
			System.out.println("Status code is "+res.statusCode() + ", try again...");
		}
}
}
}

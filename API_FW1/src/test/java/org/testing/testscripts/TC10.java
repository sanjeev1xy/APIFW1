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

public class TC10
{
@Test	
public void testCase10() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
	String bodyData=Json.loadJsonFile("../API_FW1/src/test/java/org/testing/Payloads/bodyDatForUpdate1.json");
	bodyData=JsonVariable.jsonvariablereplacement(bodyData, "id", "21");
	HTTPMethods http=new HTTPMethods(pr);
		
	System.out.println("***************TC7****************");
	for(int i=0;i<20;i++)	
	{
		Response res=http.updateRecords(bodyData, "QA_Env_UpdateEmployeeRecord_URI","21");
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
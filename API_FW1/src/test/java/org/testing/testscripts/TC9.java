package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responsevalidation.Responsevalidation;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC9 
{
    @Test
	public void TestCase9() throws IOException
	{
    	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
			
		System.out.println("***************TC9****************");
		for(int i=0;i<20;i++)	
		{
			Response res=http.getAllRecords("QA_Env_GetAllEmployeeData_URI");
			boolean statuscode=Responsevalidation.methodasperstatuscode(200, res);
			if(statuscode) 
			{
				System.out.println("Status code is "+res.statusCode());
				System.out.println("response data is "+res.asString());
				break;
			}
			else 
			{
				
				System.out.println("Status code is "+res.statusCode() + "try again...");
			}
		}
}
}

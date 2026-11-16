package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC5 
{
	@Test
public void testCase5() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
	HTTPMethods HTTP=new HTTPMethods(pr);
	Response res=HTTP.delete("QA_Env_APIStudents_URIs",TC1.responseidValue);
	System.out.println("***********TC5*************");
	System.out.println("Status Code is "+res.statusCode());
	System.out.println("Response is "+res.asString());
}
}

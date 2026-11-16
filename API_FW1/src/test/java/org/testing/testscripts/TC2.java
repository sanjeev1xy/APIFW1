package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.jsonParsing;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC2 
{
	@Test
public void testCase2() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
	HTTPMethods http=new HTTPMethods(pr);
	Response res=http.getMethod("QA_Env_ApiStudents_URI",TC1.responseidValue);
	System.out.println("*********************TC2*****************");
	System.out.println("status code is "+res.statusCode());
	System.out.println("response data is "+res.asString());
}
}

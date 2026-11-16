package org.testing.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpVersion;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.Json;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC3 
{
	@Test
public void Testcase3() throws IOException
{
	Properties pr=LoadPropertiesFile.propertiesFile("../API_FW1/URI.properties");
	HTTPMethods http =new HTTPMethods(pr);
	Response res=http.getAllRecords("QA_Env_ApiStudents_URI");
	System.out.println("*************TC3*************");
	System.out.println("status code is "+res.statusCode());
	System.out.println("response data is "+res.asString());
}
}



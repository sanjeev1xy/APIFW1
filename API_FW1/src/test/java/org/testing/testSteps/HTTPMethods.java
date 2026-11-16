package org.testing.testSteps;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HTTPMethods 
{
Properties pr;
public HTTPMethods(Properties pr)
{
	this.pr=pr;
}
public Response postMethod(String bodydata,String uriKey)
{
	Response res=
			given()
			.contentType(ContentType.JSON)
			.body(bodydata)
			.when().post(pr.getProperty(uriKey));
	System.out.println("Status code is  "+res.statusCode());
	
	return res;
}

public Response getMethod(String uriKey, String id)
{
	String uri=pr.getProperty(uriKey)+"/"+id;
	Response res=
			given()
			.contentType(ContentType.JSON)
			.when()
			.get(uri);
	     return res;		
}

public Response getAllRecords(String urikey)
{
	String uri=pr.getProperty(urikey);
	
	Response res=
	given()
	.contentType(ContentType.JSON)
	.when()
	.get(uri);
	
	return res;
}

public Response updateRecords(String bodyData,String uriKey, String idValue)
{
	String uri=pr.getProperty(uriKey)+"/"+idValue;
	Response res=
	given()
	.contentType(ContentType.JSON)
	.body(bodyData)
	.when()
	.put(uri);
	
	return res;
}

public Response delete (String uriKey, String id)
{
	String uri=pr.getProperty(uriKey)+"/"+id;
	Response res=
			given()
			.contentType(ContentType.JSON)
			.when()
			.delete(uri);
	     return res;
}

}

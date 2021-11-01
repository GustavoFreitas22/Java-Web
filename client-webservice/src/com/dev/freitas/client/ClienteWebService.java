package com.dev.freitas.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		String content = Request.Post("localhost:8080/gerenciador/empresas")
						.addHeader("Accept", "application/json").execute().returnContent().asString();
		
		System.out.println(content);

	}
	
}

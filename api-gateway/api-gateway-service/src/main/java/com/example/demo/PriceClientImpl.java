package com.example.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PriceClientImpl implements PriceClient {
	@Override
	public String getPrice() {
		String response = null;
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("http://localhost:8081/price");
			try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
				response = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}

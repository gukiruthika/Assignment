package session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONResponse {

	public static void main(String[] args) {
		new JSONResponse().getJSONResponse();
	}

	private void getJSONResponse() {
		try {
			URL url = new URL("https://reqres.in/api/unknown");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response;
			while((response=reader.readLine())!=null) {
				System.out.println(response);
			}
		} catch (MalformedURLException e) {
			System.out.println("Invalid url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

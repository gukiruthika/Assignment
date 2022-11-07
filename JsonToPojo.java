package assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonToPojo {

	public static void main(String[] args) {
		new JsonToPojo().printData();
	}

	private void printData() {
		try {
			URL url = new URL("https://reqres.in/api/unknown");
			ObjectMapper mapper = new ObjectMapper();
			String jsonData = "";
			jsonData = new JsonToPojo().getJSONResponse(url);
			System.out.println(jsonData);
			Root root = mapper.readValue(jsonData, Root.class);
			System.out.println("\nPage : " + root.page + "\nPer page : " + root.per_page + "\nTotal : " + root.total
					+ "\nTotal Pages : " + root.total_pages + "\n\nData");
			for (Datum data : root.data) {
				System.out.println("\nId : " + data.id + "\nName : " + data.name + "\nYear : " + data.year
						+ "\nColor : " + data.color + "\nPantone value : " + data.pantone_value + "\n");
			}
			System.out.println("\nSupport \nURL : " + root.support.url + "\nText : " + root.support.text);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	private String getJSONResponse(URL url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response = reader.readLine();
			return response;
		} catch (MalformedURLException e) {
			System.out.println("Invalid url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	static class Root {
		public int page;
		public int per_page;
		public int total;
		public int total_pages;
		public ArrayList<Datum> data;
		public Support support;
	}

	static class Datum {
		public int id;
		public String name;
		public int year;
		public String color;
		public String pantone_value;
	}

	static class Support {
		public String url;
		public String text;
	}

}

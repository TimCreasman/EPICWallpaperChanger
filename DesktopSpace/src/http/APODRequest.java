package http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APODRequest {

	private OkHttpClient client;
	private static final String API_KEY = "rezHqWai3ioGZOGNybZl2yw06JeLIkWHkZebimOG";

	public APODRequest() {
		client = new OkHttpClient();
	}

	public String getImageURL() throws IOException {
		String json = HttpGETRequest("https://api.nasa.gov/planetary/apod?api_key=" + API_KEY);
		return parseImageURL(json);
	}

	//TODO use a JSON reader instead of substring
	private static String parseImageURL(String response) {
		System.out.println(response);
		if (response.indexOf("hdurl\":") > 0) {
			/*String http = response.substring(response.indexOf("hdurl\":") + 9,
			                                response.indexOf(".jpg") + 4);*/
			String http = response.substring(response.indexOf("hdurl\":") + 9,
			                                response.indexOf("hdurl\":") + 13);
			String url = http + "s" + response.substring(response.indexOf("hdurl\":") + 13,
			                                response.indexOf(".jpg") + 4);
			return url;
			
		} else {
			throw new IllegalArgumentException("Not a valid URL");
		}
	}

	/**
	 * [HttpGETRequest description]
	 * @param  url         The URL to request
	 * @return             The JSON of the request
	 * @throws IOException if an invalid request was made
	 */
	private String HttpGETRequest(String url) throws IOException {
		Request request = new Request.Builder()
		.url(url)
		.build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}

}

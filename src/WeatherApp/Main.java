package WeatherApp;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
	// write your code here

        System.out.print("Enter city: ");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();

        //This is a test to commit something to GitHub


        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
//        String param1 = "Lehi";
        String param2 = "b89dac6a134713d9ac8af75b595edb0f";
// ...

        String query = String.format("?q=%s&apiKey=%s",
                URLEncoder.encode(city, charset),
                URLEncoder.encode(param2, charset));

        URLConnection connection = null;
        try {
            Gson gson = new Gson();
            connection = new URL(url + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();

            scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            WeatherConditions conditions = gson.fromJson(responseBody, WeatherConditions.class);

            System.out.println(responseBody);

            //I keep adding branches to my code....

            System.out.println(conditions.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

// ...

    }
}

package utilities;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class API {

    public  double getCurrencyConversionRestApi(String key) throws IOException {
        // use OKHttp client to create the connection and retrieve data
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://free.currconv.com/api/v7/convert?q="+key+"&compact=ultra&apiKey=1c6bc3c7fd85f3992ace")
                .build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        // parse JSON
        JSONObject mainJsonObject = new JSONObject(jsonData);
        // get Json object
//        JSONObject resultsJson = mainJsonObject.getJSONObject("rates");
        // get value
        return mainJsonObject.getDouble(key);


    }
}

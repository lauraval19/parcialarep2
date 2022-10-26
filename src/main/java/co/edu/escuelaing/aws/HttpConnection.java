package co.edu.escuelaing.aws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection{

    private static final String USER_AGENT = "Mozilla/5.0";
    PalindromoAPI api;

    public HttpConnection() {
    }

    public StringBuffer conectApi(String cad) throws IOException {
        URL obj = new URL("http://localhost:4567/index.html");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            api = new PalindromoAPI(cad);
            StringBuffer response = new StringBuffer(api.palindromo(cad));
            return response;
        }else {
            System.out.println("GET request not worked");
            return new StringBuffer("error");
        }
    }





}

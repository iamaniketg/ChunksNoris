import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class chunksNoris {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + con.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (con.getInputStream())));
            String output;
            System.out.println("Output from Server is .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }}}

package pawel.ApiReader;


import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pawel.ApiReader.model.Owner;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class ReaderService {

    public Owner getRepositoryInfo(String name, String repositoryName) throws IOException {
        URL url = new URL("https://api.github.com/repos/" + name + "/" + repositoryName);
        String urlToStr = url.toString();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponsecode" + responseCode);
        } else {
            /*System.out.println(responseCode);
            System.out.println("Parsig json");
*/
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();

            JSONObject myResponse = new JSONObject(response.toString());
            Owner owner = new Owner();
            owner.setFullName(myResponse.getString("full_name"));
            owner.setDescription(myResponse.getString("name"));
            owner.setCloneURL(myResponse.getString("clone_url"));
            owner.setStars(myResponse.getInt("stargazers_count"));
            owner.setCreatedAt(myResponse.getString("created_at"));

      //      System.out.println(owner);
            return owner;
        }

    }
}

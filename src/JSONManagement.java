import controller.PostController;
import model.Post;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONManagement {
    PostController postController = new PostController();

    public void readJSONFromApijsonplaceholder() throws Exception {

        try {
            String apiURL = "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject post
                        = (org.json.JSONObject) jsonArray.get(i);

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();

                Post newPost = new Post(
                        Integer.parseInt(post.get("id").toString()),
                        Integer.parseInt(post.get("userId").toString()),
                        post.get("title").toString(),
                        post.get("body").toString()
                );
                //insert into DB
                System.out.println("Inserting.......");
                postController.insertNewPost(newPost);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

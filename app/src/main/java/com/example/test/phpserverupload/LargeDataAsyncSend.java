package com.example.test.phpserverupload;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by test on 20.03.2015.
 */
public class LargeDataAsyncSend {

        private static final String BASE_URL = "http://api.twitter.com/1/";


    public LargeDataAsyncSend() {

        RequestParams params = new RequestParams();
        params.put("username", "james");
        params.put("password", "123456");
        params.put("email", "my@email.com");

        File myFile = new File("/mnt/shared/shared_folder_for_genymotion/Desert.jpg"); // Upload a File
        try {
            params.put("profile_picture",myFile);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        params.put("profile_picture2", someInputStream); // Upload an InputStream
        params.put("profile_picture3", new ByteArrayInputStream(someBytes)); // Upload some bytes

        Map<String, String> map = new HashMap<String, String>();
        map.put("first_name", "James");
        map.put("last_name", "Smith");
        params.put("user", map); // url params: "user[first_name]=James&user[last_name]=Smith"

        Set<String> set = new HashSet<String>(); // unordered collection
        set.add("music");
        set.add("art");
        params.put("like", set); // url params: "like=music&like=art"

        List<String> list = new ArrayList<String>(); // Ordered collection
        list.add("Java");
        list.add("C");
        params.put("languages", list); // url params: "languages[]=Java&languages[]=C"

        String[] colors = { "blue", "yellow" }; // Ordered collection
        params.put("colors", colors); // url params: "colors[]=blue&colors[]=yellow"

        List<Map<String, String>> listOfMaps = new ArrayList<Map<String,
                String>>();
        Map<String, String> user1 = new HashMap<String, String>();
        user1.put("age", "30");
        user1.put("gender", "male");
        Map<String, String> user2 = new HashMap<String, String>();
        user2.put("age", "25");
        user2.put("gender", "female");
        listOfMaps.add(user1);
        listOfMaps.add(user2);
        params.put("users", listOfMaps); // url params: "users[][age]=30&users[][gender]=male&users[][age]=25&users[][gender]=female"

        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://192.168.31.1/phpresimalma/php_resim_alma.php", params,  new AsyncHttpResponseHandler());
    }
}


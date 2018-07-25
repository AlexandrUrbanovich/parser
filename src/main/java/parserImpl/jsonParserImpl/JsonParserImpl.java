package parserImpl.jsonParserImpl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import parser.ParserI;
import parserImpl.User;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JsonParserImpl implements ParserI {

    private static final Logger log = Logger.getLogger(String.valueOf(JsonParserImpl.class));

    @Override
    public List<User> parser() {
        List<User> users = new ArrayList<>();
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject objectJson = jsonParser.parse(new FileReader("src/main/resources/users.json")).getAsJsonObject();

            JsonArray usersJson = objectJson.getAsJsonArray("users");

            for(JsonElement user : usersJson){

                String firstName =  user.getAsJsonObject().get("firstName").getAsString();
                String lastName =  user.getAsJsonObject().get("lastName").getAsString();
                Integer age =  user.getAsJsonObject().get("age").getAsInt();

                User currentUser = new User(firstName, lastName, age);
                users.add(currentUser);

                log.info("In User was added data from JSON file");
            }

        }catch (Exception e){
            e.printStackTrace(System.out);
        }

        log.info("Data read from users.json");

        System.out.println("List");
        for (User person : users) {
            System.out.println(person);
        }
        return users;
    }
}
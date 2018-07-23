package parserImpl.jsonParserImpl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import parser.jsonParser.JsonParserI;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParserImpl implements JsonParserI {

    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void parser() {
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject objectJson = jsonParser.parse(new FileReader("src/main/resource/users.json")).getAsJsonObject();

            JsonArray users = objectJson.getAsJsonArray("users");

            for(JsonElement user : users){

                String firstName =  user.getAsJsonObject().get("firstName").getAsString();
                String lastName =  user.getAsJsonObject().get("lastName").getAsString();
                Integer age =  user.getAsJsonObject().get("age").getAsInt();

                User currentUser = new User(firstName, lastName, age);
                getUsers().add(currentUser);
            }


        }catch (Exception e){
            e.printStackTrace(System.out);
        }

    }



}
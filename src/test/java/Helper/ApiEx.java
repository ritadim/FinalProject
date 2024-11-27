package Helper;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiEx {

     public RequestSpecification httpRequest;
     public Response response;
     String baseUrl ="https://reqres.in/";
     String pageNum2 = "2";
     JsonPath jp;
     JSONObject params;


     @BeforeClass
     public void start(){
          RestAssured.baseURI = baseUrl;
          httpRequest = RestAssured.given();
          httpRequest.header("Content-Type","application/json");
     }
     //post
     @Test
     public void test01(){
          params = new JSONObject();
          params.put("name","Lala");
          params.put("job","QA");;
          httpRequest.body(params.toJSONString());
          response = httpRequest.post("api/users");
          jp =response.jsonPath();
          String name = jp.getString("name");
          System.out.println(name);
          assertEquals(name,"Lala");
     }
     //get
     @Test
    public void test02(){
         response = httpRequest.get("api/users?page=" + pageNum2);
         jp = response.jsonPath();
         response.prettyPrint();
          String[] names  = jp.getString("data.first_name").split(", ");
          String[] addedName = names[names.length-1].split("]");
          System.out.println(addedName[0]);
          assertEquals(addedName[0],"Rachel");
     }
     //put
     @Test
     public void test03(){
         params = new JSONObject();
         params.put("name","Rita");
         params.put("job","dev");
         httpRequest.body(params.toJSONString());
         response = httpRequest.put("api/users/2");
         jp =response.jsonPath();
         String job = jp.getString("job");
         assertEquals(job,"dev");
     }
     @Test
    public void test04(){
         response = httpRequest.delete("api/users/2");
         assertEquals(response.getStatusCode(),204);
     }
}

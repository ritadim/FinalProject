package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {
    @Step("get data from server")
    public static Response get(String resources){
        response = httpRequest.get(resources);
        response.prettyPrint();
        return response;
    }
    @Step("extract data from Json format")
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        System.out.println(jp.getString(path));
        return jp.getString(path);
    }
    @Step("Post data to server and return the response")
    public static Response post(String resources, JSONObject params){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resources);
        response.prettyPrint();
        return response;
    }
    @Step("extract data from specific record, using the number of the record")
    public static String getRecordData(Response response,String path, int recordNumber){
        jp = response.jsonPath();
        String[] array = jp.getString(path).split(", ");
        for(String x: array){
            System.out.println(x);
        }
        if(recordNumber<7){
            if(recordNumber==6){
                String data = array[recordNumber-1].split("]")[0];
                return data;
            } else if (recordNumber==1) {
                String data = array[recordNumber-1].split("")[0];
                return data;
            }
            else
                return array[recordNumber-1];
        }
        else {
            if(recordNumber==12){
                String data = array[recordNumber-7].split("]")[0];
                return data;
            } else if (recordNumber==7) {
                String data = array[recordNumber-7].split("")[0];
                return data;
            }
            else
                return array[recordNumber-7];
           }
        }
    @Step("update data in the server and return the response")
    public static Response put(String resources,JSONObject params){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resources);
        response.prettyPrint();
        return response;
    }
    @Step("delete data from server")
    public static Response delete(String resources){
        response = httpRequest.delete(resources);
        response.prettyPrint();
        return response;
    }
}
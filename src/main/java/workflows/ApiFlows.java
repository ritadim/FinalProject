package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: extracts data from the response")
    public static String getUserData(String jpath, String pageNum,int recordNumber) {
        response = ApiActions.get("/api/users?page=" + pageNum);
        return ApiActions.getRecordData(response,jpath,recordNumber);
    }

    @Step("Business Flow: adds new data")
    public static Response postUser(String name, String job){
        params.put("name",name);
        params.put("job", job);
        return ApiActions.post("/api/users",params);
    }

    @Step("Business Flow: update existing data")
    public static Response updateUser(String name, String job){
        params.put("name",name);
        params.put("job", job);
        return ApiActions.put("/api/users/2",params);
    }
    @Step("Business Flow: delete data from server")
    public static Response deleteUser(){
        return ApiActions.delete("/api/users/2");
    }
}
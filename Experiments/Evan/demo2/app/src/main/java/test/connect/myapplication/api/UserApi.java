package test.connect.myapplication.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import test.connect.myapplication.model.User;

public interface UserApi {

    @POST("/signUp")
    Call<String> addNewUser(String name, String email, String username, String hashed_pass);

    @GET("/allUsers")
    Call<Iterable<User>> getAllUsers();

    @POST("/login")
    Call<String> userLogin(String emailOrUserName, String hashedPass);

}
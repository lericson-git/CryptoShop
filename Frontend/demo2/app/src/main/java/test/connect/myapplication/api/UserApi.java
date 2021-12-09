package test.connect.myapplication.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.LoginDTO;
import test.connect.myapplication.model.User;

/**
 *these are the GET/POST urls to get information from the backend
 */
public interface UserApi {

    /**
     * this is used to add a new user to the database
     * @param newUser the User you wish to add to the database
     * @return the newly created User, or null if there were issues with the user information
     */
    @POST("/signUp")
    Call<User> addNewUser(@Body User newUser);

    /**
     * returns a list of Users containing all users within the database
     * @return a list of Users containing all users within the database
     */
    @GET("/allUsers")
    Call<List<User>> GetAllUser();

    /**
     * used to login a user
     * @param user to login
     * @return success string or error string
     */
    @POST("/login")
    Call<ResponseBody> userLogin(@Body LoginDTO user);

    /**
     * used to get a user by ther id
     * @param userId id of user to get
     * @return the user whose id matches the string
     */
    @GET("/user/{id}")
    Call<User> getUserById(@Path("id") int userId);

    @GET("/usernameOrEmail/{emailOrUsername}")
    Call<User> getUsernameOrEmail(@Path("emailOrUsername") String emailOrUsername);

}
package test.connect.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Setup communication between backend and frontend
 */
public class ApiClientFactory {

    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed() {

        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    //.baseUrl("http://10.24.227.81:8080/")
                    .baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return apiClientSeed;
    }


    public static PostApi GetPostApi(){
        return GetApiClientSeed().create(PostApi.class);
    }

    public static UserApi GetUserApi(){
        return GetApiClientSeed().create(UserApi.class);
    }

    public static ProductApi GetProductApi(){ return GetApiClientSeed().create(ProductApi.class);
    }
}

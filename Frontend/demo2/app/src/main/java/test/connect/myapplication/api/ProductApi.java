package test.connect.myapplication.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.connect.myapplication.model.Product;

/**
 *these are the GET/POST urls to get information from the backend
 */
public interface ProductApi {

    @GET("/product/{id}")
    Call<Product> getProductById(@Path("id") int productId);


}
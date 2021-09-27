package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetPostApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.connect.myapplication.model.Post;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView apiText1 = findViewById(R.id.activity_main_textView1);

        GetPostApi().getFirstPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                apiText1.setText(response.body().getBigText());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // Use to log our failures by using t
                //here
            }
        });

    }
}

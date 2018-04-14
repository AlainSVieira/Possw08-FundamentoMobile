package petdoe.com.br.petdoe.application;

import android.app.Application;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import petdoe.com.br.petdoe.model.service.IService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mychelle on 13/04/2018.
 */

public class MyApplication extends Application {
    private static MyApplication singleton;
    private static final int TIMEOUT = 60;
    private IService mService;
    private static final String BASE_URL = "http://alamyc.ddns.net:8080/petdoeserver/ws/";

    public static MyApplication getInstance(){

        if (singleton== null) {
            synchronized(MyApplication.class) {
                if (singleton == null)
                    singleton = new MyApplication();
            }
        }
        // Return the instance

        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;


    }

    public void setupRetrofit() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                              //  .header(apiKey, apiKeyValue)
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mService = retrofit.create(IService.class);


    }

    public IService getService() {
        return mService;
    }
}
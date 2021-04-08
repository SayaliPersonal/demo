package com.example.cswork.network.teams;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cswork.network.EndPoints;
import com.example.cswork.network.auth.AuthResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamsRepository {

    private static final String AUTH_BASE_URL = "https://identity.officernd.com/";
    private EndPoints endPoints;
    private MutableLiveData<AuthResponse> authResponseMutableLiveData;


    public TeamsRepository() {
        authResponseMutableLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        endPoints = new retrofit2.Retrofit.Builder()
                .baseUrl(AUTH_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EndPoints.class);

    }

    public void authenticateAPI(String clientId, String clientSecret, String grantType,
                                String scope) {
        endPoints.authenticate(clientId, clientSecret, grantType, scope)
                .enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        if (response.body() != null) {
                            authResponseMutableLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        authResponseMutableLiveData.postValue(null);
                    }
                });
    }

    public LiveData<AuthResponse> getAuthenticateAPILivaData() {
        return authResponseMutableLiveData;
    }

}

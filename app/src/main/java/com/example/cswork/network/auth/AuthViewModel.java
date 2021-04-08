package com.example.cswork.network.auth;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class AuthViewModel extends AndroidViewModel {

    private AuthRepository authRepository;
    private LiveData<AuthResponse> authResponseLiveData;

    public AuthViewModel(@NonNull Application application) {
        super(application);
    }

    public void init()  {
        authRepository = new AuthRepository();
        authResponseLiveData =authRepository.getAuthenticateAPILivaData();
    }

    public void doAuthentication(String clientId, String clientSecret, String grantType,
                                 String scope) {
        authRepository.authenticateAPI(clientId, clientSecret, grantType, scope);
    }

    public LiveData<AuthResponse> getAuthResponseLiveData() {
        return authResponseLiveData;
    }
}

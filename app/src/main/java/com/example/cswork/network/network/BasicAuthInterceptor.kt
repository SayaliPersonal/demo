package com.example.cswork.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class BasicAuthInterceptor(user: String?, password: String?) : Interceptor {

    private var credentials: String? = null

    init {
        credentials = Credentials.basic(user!!, password!!)

    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        val authenticatedRequest: Request =
            req.newBuilder().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJOYW1lIjoiVGVzdCBVc2VyIiwiRW1haWwiOiJUZXN0QGdtYWlsLmNvbSIsIlVzZXJJZCI6IjEiLCJVc2VySWRlbnRpdHlLZXkiOiJUZXN0MTIzIiwiZXhwIjoxNjE4NjQ3MjI2LCJpc3MiOiJodHRwczovL2xvY2FsaG9zdDo0NDMwMC8iLCJhdWQiOiJodHRwczovL2xvY2FsaG9zdDo0NDMwMC8ifQ.p9eRs9tgZG9UITpdZHMMnYHr-Of0tzi77x4gnC8xVgc").build()
        return chain.proceed(authenticatedRequest)
    }
}
package kr.rmsxo.data.retrofit

import kotlinx.coroutines.runBlocking
import kr.rmsxo.data.UserDataStore
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RMInterceptor @Inject constructor(
    private val userDataStore: UserDataStore
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token:String? = runBlocking { userDataStore.getToken() }
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    if(token.isNullOrEmpty()){
                        this
                    }else{
                        this.addHeader("Token", token)
                    }
                }
                .addHeader("Content-Type", "application/json; charset=UTF8")
                .build()
        )
    }

}
package io.github.rakshakhegde.retrolinsample

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CustomerApiInterface {

	@POST("api/signIn")
	fun signIn(@Body emailPassword: EmailPassword): Call<SignInResponse>
}

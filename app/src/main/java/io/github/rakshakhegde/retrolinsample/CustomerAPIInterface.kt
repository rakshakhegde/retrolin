package io.github.rakshakhegde.retrolinsample

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface CustomerApiInterface {

	@GET
	fun call(): Call<MyResponse>
}

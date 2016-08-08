package io.github.rakshakhegde.retrolinsample

import enqueue
import retrofit2.Retrofit


fun makeRetrofitCall() {
	val API_BASE_URL = "https://www.google.com"

	val myApi = Retrofit.Builder()
			.baseUrl(API_BASE_URL)
			.build()
			.create(CustomerApiInterface::class.java)

	// Actual usage of the library
	myApi.call().enqueue {

		onResponse { call, response ->
			println(response.body())
		}

		onFailure { call, throwable ->
			throwable.printStackTrace()
		}
	}
}

package io.github.rakshakhegde.retrolinsample

import retrofit2.Retrofit

val API_BASE_URL = "https://www.google.com"

val customerApi by lazy {
	Retrofit.Builder()
			.baseUrl(API_BASE_URL)
			.build()
			.create(CustomerApiInterface::class.java)
}

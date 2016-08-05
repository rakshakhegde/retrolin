package io.github.rakshakhegde.retrolinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import enqueue
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainActivity : AppCompatActivity(), AnkoLogger {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		customerApi.signIn(EmailPassword("email@abc.com", "password123"))
				.enqueue {
					onResponse { call, response ->
						info(response.body())
					}
					onFailure { call, throwable ->
						throwable.printStackTrace()
					}
				}
	}
}

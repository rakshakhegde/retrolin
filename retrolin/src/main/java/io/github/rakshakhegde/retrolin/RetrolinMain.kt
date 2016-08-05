import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Rakshak R.Hegde
 * @date 01/08/16
 */

fun <T> Call<T>.enqueue(init: CallbackWatcher<T>.() -> Unit) {
	val listener = CallbackWatcher<T>()
	listener.init()
	enqueue(listener)
}

class CallbackWatcher<T> : Callback<T> {
	private var _onResponse: ((Call<T>, Response<T>) -> Unit)? = null
	private var _onFailure: ((Call<T>, Throwable) -> Unit)? = null

	override fun onResponse(call: Call<T>, response: Response<T>) {
		_onResponse?.invoke(call, response)
	}

	fun onResponse(listener: (Call<T>, Response<T>) -> Unit) {
		_onResponse = listener
	}

	override fun onFailure(call: Call<T>, t: Throwable) {
		_onFailure?.invoke(call, t)
	}

	fun onFailure(listener: (Call<T>, Throwable) -> Unit) {
		_onFailure = listener
	}
}

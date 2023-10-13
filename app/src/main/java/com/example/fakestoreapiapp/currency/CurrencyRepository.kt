import androidx.lifecycle.MutableLiveData
import com.example.fakestoreapiapp.currency.CurrencyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyRepository {

    val livedata: MutableLiveData<Double?> = MutableLiveData()

    fun convertCurrency(from: String?, to: String?, quantity: Int): MutableLiveData<Double?> {

        val call = CurrencyRetrofit().apiCall.convertCurrency(from, to, quantity)
        call?.enqueue(object : Callback<Double?> {
            override fun onResponse(call: Call<Double?>, response: Response<Double?>) {
                if (response.isSuccessful) {

                        livedata.value=response.body()

                } else {

                }
            }

            override fun onFailure(call: Call<Double?>, t: Throwable) {

            }
        })
        return livedata
    }
}

package ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import anirudh.com.explorekotlin.R
import model.RedditNewsResponse
import rest.RestApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RestApiSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_api_sample)

        //get your rest service
        val restService: RestApi = RestApi()

        //call rest service method
        getNewsData(restService)
    }

    private fun getNewsData(restService: RestApi) {
        restService.getRestService().getTop("0", "10")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                })
    }
}

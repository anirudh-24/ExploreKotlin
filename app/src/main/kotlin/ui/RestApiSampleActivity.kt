package ui

import adapter.RetrofitSampleAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import anirudh.com.explorekotlin.R
import kotlinx.android.synthetic.main.activity_rest_api_sample.*
import model.RedditChildrenResponse
import rest.RestApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

class RestApiSampleActivity : AppCompatActivity() {

    private var mAdapter: RetrofitSampleAdapter? = null
    private var mDataList: ArrayList<RedditChildrenResponse>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_api_sample)

        //get your rest service
        val restService: RestApi = RestApi()
        recyclerRetrofitTest.layoutManager = LinearLayoutManager(this)
        mDataList = ArrayList<RedditChildrenResponse>()
        mAdapter = RetrofitSampleAdapter(mDataList as ArrayList<RedditChildrenResponse>, this)
        recyclerRetrofitTest.adapter = mAdapter
        //call rest service method
        getNewsData(restService)
    }

    private fun getNewsData(restService: RestApi) {
        restService.getRestService().getTop("0", "10")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ RedditNewsResponse ->
                    mDataList?.addAll(RedditNewsResponse?.data?.children!!.asIterable())
                    mAdapter?.notifyDataSetChanged()
                },
                        { e -> Log.e("on error", e.message) });
    }
}

package ui

import adapter.RetrofitSampleAdapter
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import anirudh.com.explorekotlin.R
import kotlinx.android.synthetic.main.activity_rest_api_sample.*
import model.RedditChildrenResponse
import rest.RestApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by anirudh on 27-05-16
 * contains simple rest service and paging integration using retrofit
 * also contains implementation of swipe refresh layout in Android
 */

class RestApiSampleActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private var mAdapter: RetrofitSampleAdapter? = null
    private var mDataList: ArrayList<RedditChildrenResponse>? = null
    private var index: Int = 0
    private var restService: RestApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_api_sample)

        //get your rest service
        restService = RestApi()
        recyclerRetrofitTest.layoutManager = LinearLayoutManager(this)
        mDataList = ArrayList<RedditChildrenResponse>()
        mAdapter = RetrofitSampleAdapter(mDataList as ArrayList<RedditChildrenResponse>, this)
        recyclerRetrofitTest.adapter = mAdapter

        //set listener to swipe layout
        swipeLayout.setOnRefreshListener(this)

        //call rest service method
        progressBar.visibility = View.VISIBLE
        getNewsData()

        //on click listener on load more button
        btnLoadMore.setOnClickListener { view ->
            index += 10
            progressBar.visibility = View.VISIBLE
            getNewsData()
        }
    }

    /**
     * Hit the service to get the data from the api
     */
    private fun getNewsData() {
        restService?.getRestService()?.getTop(index.toString(), "10")?.
                subscribeOn(Schedulers.newThread())?.
                observeOn(AndroidSchedulers.mainThread())?.
                subscribe({ RedditNewsResponse ->
                    mDataList?.addAll(RedditNewsResponse?.data?.children!!.asIterable())
                    mAdapter?.notifyDataSetChanged()
                    swipeLayout.isRefreshing = false
                    progressBar.visibility = View.GONE
                },
                        { e ->
                            swipeLayout.isRefreshing = false
                            progressBar.visibility = View.GONE
                            if (index != 0)
                                index -= 10
                            Log.e("on error", e.message)
                            Snackbar.make(recyclerRetrofitTest, e.message.toString(), Snackbar.LENGTH_LONG)
                        });
    }

    //clear all data and call the service again
    override fun onRefresh() {
        index = 0
        mDataList?.clear()
        mAdapter?.notifyDataSetChanged()
        getNewsData()
    }

}

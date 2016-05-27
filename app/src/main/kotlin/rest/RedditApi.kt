package rest

import model.RedditNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by anirudh on 27/5/16.
 * Rest Api Interface
 */
interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String)
            : Observable<RedditNewsResponse> ;
}
package model

/**
 * Created by anirudh on 27/5/16.
 * Model with a simple constructor and no secondary constructor
 */
class RedditNewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)
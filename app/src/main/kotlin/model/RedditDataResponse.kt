package model

/**
 * Created by anirudh on 27/5/16.
 */
class RedditDataResponse (val children: List<RedditChildrenResponse>,
    val after: String?,
    val before: String?
)
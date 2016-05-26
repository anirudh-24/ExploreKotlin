package model

/**
 * Created by anirudh on 26/5/16.
 * model for recycler view data
 */
class DemoRecyclerModel {

    var title = ""
    var subTitle = ""

    //a secondary constructor for the class
    constructor(title: String, subtitle: String) {
        this.title = title
        this.subTitle = subtitle
    }

    //function that returns the value of title
    fun getTitleValue(): String {
        return title
    }

    //function that returns the value of sub title
    fun getSubTitleValue(): String {
        return subTitle
    }
}

package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import anirudh.com.explorekotlin.R
import model.DemoRecyclerModel
import java.util.*

/**
 * Created by anirudh on 26/5/16.
 * Adapter to set data to recycler view
 */

//this is an example of primary constructor of a class
class DemoRecyclerViewAdapter(var mDataList: ArrayList<DemoRecyclerModel>, val mContext: Context) : RecyclerView.Adapter<DemoRecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textTitle?.text = mDataList[position].getTitleValue()  // access value from ArrayList like an Array
        holder?.textSubTitle?.text = mDataList[position].getSubTitleValue()
    }

    //return viewholder
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_demo_recyclerview, parent, false))
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    //view holder for adapter
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var textTitle = itemView?.findViewById(R.id.txtTitle) as TextView
        var textSubTitle = itemView?.findViewById(R.id.txtSubTitle) as TextView
    }
}
package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import model.DemoRecyclerModel
import java.util.*

/**
 * Created by anirudh on 26/5/16.
 * Adapter to set data to recycler view
 */

//this is an example of primary constructor of a class
class DemoRecyclerViewAdapter(var mDataList: ArrayList<DemoRecyclerModel>, val mContext: Context) : RecyclerView.Adapter<DemoRecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        throw UnsupportedOperationException()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        throw UnsupportedOperationException()
    }

    override fun getItemCount(): Int {
        throw UnsupportedOperationException()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}
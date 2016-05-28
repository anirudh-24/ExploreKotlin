package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import anirudh.com.explorekotlin.R
import com.bumptech.glide.Glide
import model.RedditChildrenResponse
import model.RedditNewsDataResponse
import java.util.*

/**
 * Created by Anirudh on 28-05-2016.
 * Adapter to set data on recycler view
 */
class RetrofitSampleAdapter(var mDataList: ArrayList<RedditChildrenResponse>, val mContext: Context) : RecyclerView.Adapter<RetrofitSampleAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        return (ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_demo_recyclerview, parent, false)))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val data: RedditNewsDataResponse = mDataList[position].data
        holder?.textTitle?.isSelected = true
        holder?.textTitle?.text = data.title
        holder?.textSubTitle?.text = data.author
        Glide.with(mContext).load(data.thumbnail).error(R.mipmap.ic_launcher).into(holder?.imageView)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView?.findViewById(R.id.imageView) as ImageView
        var textTitle = itemView?.findViewById(R.id.txtTitle) as TextView
        var textSubTitle = itemView?.findViewById(R.id.txtSubTitle) as TextView
    }
}
package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
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
        return (ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rest_api_demo, parent, false)))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val data: RedditNewsDataResponse = mDataList[position].data
        holder?.textTitle?.isSelected = true
        holder?.textTitle?.text = data.title
        holder?.textAuthor?.text = String.format("%1s: %2s", "Author", data.author)
        holder?.textTime?.text = String.format("%1s: %2s", "Created", getDate(data.created))
        Glide.with(mContext).load(data.thumbnail).error(R.mipmap.ic_launcher).into(holder?.imageView)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView?.findViewById(R.id.imageView) as ImageView
        var textTitle = itemView?.findViewById(R.id.txtTitle) as TextView
        var textAuthor = itemView?.findViewById(R.id.txtAuthor) as TextView
        var textTime = itemView?.findViewById(R.id.txtTime) as TextView
    }

    //convert time in milliseconds to date
    private fun getDate(time: Long): String {
        val cal: Calendar = Calendar.getInstance(Locale.ENGLISH);
        cal.timeInMillis = time;
        val date: String = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }
}
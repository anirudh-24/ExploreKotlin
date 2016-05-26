package ui

import adapter.DemoRecyclerViewAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import anirudh.com.explorekotlin.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import model.DemoRecyclerModel
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //set layout manager to your recycler view
        recyclerTest.layoutManager = LinearLayoutManager(this)

        val testTitleArr = arrayOf("Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8")
        val testSubTitleArr = arrayOf("SubTitle 1", "SubTitle 2", "SubTitle 3", "SubTitle 4", "SubTitle 5", "SubTitle 6","SubTitle 7","SubTitle 8")

        //ArrayList initialization
        val listData: ArrayList<DemoRecyclerModel> = ArrayList()

        //for loop to loop across array
        for (i in testTitleArr.indices) {
            val model = DemoRecyclerModel(testTitleArr[i], testSubTitleArr[i])
            listData.add(model)
        }

        //set adapter to recycler view
        recyclerTest.adapter = DemoRecyclerViewAdapter(listData, this)
    }
}

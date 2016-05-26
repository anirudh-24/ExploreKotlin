package ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import anirudh.com.explorekotlin.R
import kotlinx.android.synthetic.main.activity_simple_list_implementation.*

/**
 * Created By Anirudh on 26-05-16
 * This activity contains basic implementation of ListView and its usage using a simple ArrayAdapter
 */

class SimpleListImplementationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_implementation)

        //create a simple array (no more String a[] = {"a","b"}) simple use arrayOf
        val testArr = arrayOf("item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10")

        //create an instance of ArrayAdapter (yep no more use of new keyword)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, testArr)

        //set adapter on list view
        // (no more set adapter :) although this redirects to serAdapter of ListView but is more cleaner)
        lstTest.adapter = adapter

        //on item click listener on ListView
        lstTest.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l -> Toast.makeText(this, testArr[position] + " clicked", Toast.LENGTH_SHORT).show() }
    }
}

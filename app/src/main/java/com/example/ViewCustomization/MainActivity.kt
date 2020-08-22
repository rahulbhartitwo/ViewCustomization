package com.example.ViewCustomization

import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ViewCustomization.adapter.MainAdapter
import com.example.ViewCustomization.utils.BaseActivity
import com.example.ViewCustomization.utils.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onSuccess()
    }

    private fun onSuccess() {
        val topMargin =
            (-TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f, resources.displayMetrics)).toInt()
        val itemDecorator =
            ItemDecorator(topMargin)

        cv.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = MainAdapter(this@MainActivity, 10)
            adapter?.notifyDataSetChanged()
            addItemDecoration(itemDecorator)
        }
    }
}
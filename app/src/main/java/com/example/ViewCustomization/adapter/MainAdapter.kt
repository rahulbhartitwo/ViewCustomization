package com.example.ViewCustomization.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.ViewCustomization.R
import kotlinx.android.synthetic.main.custom_layout.view.*


class MainAdapter(var context: Context, var mList: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                One(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.custom_layout, parent, false), context
                )
            }
            else -> {
                One(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.custom_layout,
                        parent,
                        false
                    ), context
                )
            }
        }
    }

    class One(itemView: View, var context: Context) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var image: ImageView = itemView.imageView
        var progressBar: ProgressBar = itemView.progressBar

        init {
            image.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            when (p0?.id) {
                R.id.imageView -> {
//
                }
                else -> {
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is One)
            when (1) {
                1 -> {
                    holder.progressBar.visibility = View.VISIBLE
                    Glide.with(context)
                        .load(
                            if (position % 2 == 0)
                                ContextCompat.getDrawable(
                                    context,
                                    R.drawable.b
                                )!! else ContextCompat.getDrawable(context, R.drawable.d)!!
                        )
                        .listener(object : RequestListener<Drawable?> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: com.bumptech.glide.request.target.Target<Drawable?>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                holder.progressBar.visibility = View.GONE
                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: com.bumptech.glide.request.target.Target<Drawable?>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                holder.progressBar.setVisibility(View.GONE)
                                return false
                            }
                        }).into(holder.image)
                }
                else -> {
                }
            }
    }

    override fun getItemCount(): Int {
        return mList
    }

    override fun getItemViewType(position: Int): Int {
        return when (1) {
            1 -> {
                1
            }
            2 -> {
                2
            }
            else -> {
                1
            }
        }
    }
}
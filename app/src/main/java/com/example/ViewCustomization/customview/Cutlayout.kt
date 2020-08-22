package com.example.ViewCustomization.customview

import android.annotation.TargetApi
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout

class CutLayout : FrameLayout {
    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val pdMode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    private val path: Path = Path()

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    ) {
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context!!, attrs, defStyleAttr, defStyleRes) {
    }

    override fun dispatchDraw(canvas: Canvas) {
        val saveCount = canvas.saveLayer(
            0.toFloat(), 0.toFloat(), width.toFloat(),
            height.toFloat(), null, Canvas.ALL_SAVE_FLAG
        )
        super.dispatchDraw(canvas)

        paint.xfermode = pdMode
        path.reset()

        path.moveTo(0f, 0f)
        path.lineTo(width.toFloat(), 0f)
        path.lineTo(
            0f,
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f, resources.displayMetrics)
        )
        path.close()
        canvas.drawPath(path, paint)

        path.reset()

        path.moveTo(0f, height.toFloat())
        path.lineTo(width.toFloat(), height.toFloat())
        path.lineTo(
            width.toFloat(),
            height - TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                50f,
                resources.displayMetrics
            )
        )
        path.close()
        canvas.drawPath(path, paint)

        canvas.restoreToCount(saveCount)
        paint.xfermode = null
    }
}
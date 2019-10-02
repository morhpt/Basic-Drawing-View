package com.morhpt.drawingview

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import org.jetbrains.anko.AnkoLogger
import android.graphics.Bitmap
import org.jetbrains.anko.sdk25.coroutines.onTouch

/**
 * This class creates a view that allow you to paint on the canvas
 *
 * @param ctx the context
 */
class DrawingView(ctx: Context) : View(ctx), AnkoLogger {

    private var mBitmap: Bitmap? = null
    private var mCanvas: Canvas? = null
    private val mPath: Path = Path()
    private val mPaint: Paint = Paint()
    private var mX: Float = 0f
    private var mY: Float = 0f

    var stroke: Float
        get() = mPaint.strokeWidth
        set(w) {
            mPaint.strokeWidth = w
        }
    var color: Int
        get() = mPaint.color
        set(clr) {
            mPaint.color = clr
        }
    var style: Paint.Style
        get() = mPaint.style
        set(w) {
            mPaint.style = w
        }
    var isAntiAlias: Boolean
        get() = mPaint.isAntiAlias
        set(value) {
            mPaint.isAntiAlias = value
        }
    var strokeJoin: Paint.Join
        get() = mPaint.strokeJoin
        set(value) {
            mPaint.strokeJoin = value
        }
    val bitmap: Bitmap get() = loadBitmapFromView()

    /**
     * @constructor sets paint's styles
     */
    init {
        isAntiAlias = true
        color = Color.RED
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        stroke = 20f
    }

    /**
     * This function start the movement and sets x and y values
     *
     * @param x the x axis
     * @param y the y axis
     */
    private fun startTouch(x: Float, y: Float) {
        mPath.moveTo(x, y)
        mX = x
        mY = y
    }

    /**
     * this function calculates and moves/paint the finger signature
     *
     * @param x the x axis
     * @param y the y axis
     */
    private fun moveTouch(x: Float, y: Float) {
        val dx = Math.abs(x - mX)
        val dy = Math.abs(y - mY)
        if (dx >= 5.0f || dy >= 5.0f) {
            mPath.quadTo(mX, mY, (x + mX) / 2.0f, (y + mY) / 2.0f)
            mX = x
            mY = y
        }
    }

    /**
     * This function finishes the drawing action
     */
    private fun upTouch() {
        mPath.lineTo(mX, mY)
    }

    /**
     * This function creates and return a bitmap of the current view
     *
     * @return created bitmap of the current view
     */
    private fun loadBitmapFromView(): Bitmap {
        val v = this
        val b = Bitmap.createBitmap(v.layoutParams.width, v.layoutParams.height, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        v.layout(v.left, v.top, v.right, v.bottom)
        v.draw(c)
        return b
    }

    /**
     * This function best if the [refresh] function not refreshingx
     */
    fun hardRefresh() {
        startTouch(0f, 0f)
        upTouch()
    }

    /**
     * This function clears the canvas
     */
    fun clearCanvas() {
        try {
            mPath.reset()
            invalidate()
        } catch (_: Exception) {
        }
    }

    /**
     * This function refreshes the view if there is a chances it shows after the refresh
     */
    fun refresh() {
        invalidate()
    }

    /**
     * This function creates a pixel on the given location
     *
     * @param x the x axis
     * @param y the y axis
     * @param refresh if true refresh the view after created pixel
     * @param hardRefresh if true refresh for sure the view after created pixel
     * @param rectF the [RectF] object
     */
    fun setPixel(x: Float, y: Float, refresh: Boolean = false, hardRefresh: Boolean = false, rectF: RectF = RectF(x, y, x + 0.1f, y + 0.1f)) {
        mPath.addRect(rectF, Path.Direction.CCW)
        if (refresh) invalidate()
        if (hardRefresh) hardRefresh()

    }

    override fun setOnTouchListener(l: OnTouchListener?) {
        onTouch { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN)
                setPixel(event.x, event.y, hardRefresh = true)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> startTouch(x, y)
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> upTouch()
            MotionEvent.ACTION_MOVE -> moveTouch(x, y)
            else -> return true
        }
        invalidate()
        return true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        mCanvas = Canvas(mBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(mPath, mPaint)
    }
}

package com.morhpt.basicdrawingview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.morhpt.drawingview.DrawingView
import com.morhpt.drawingview.drawingView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    val rand = Random()

    lateinit var drawView: DrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        verticalLayout {
            backgroundColor = Color.GRAY

            drawingView {
                drawView = this
                backgroundColor = Color.WHITE

            }.lparams(width = dip(dpWidth), height = dip(dpWidth))

            verticalLayout {
                padding = dip(16)
                linearLayout {
                    button("refresh").onClick { drawView.refresh() }
                    button("clear").onClick { drawView.clearCanvas() }
                    button("change pixel size").onClick {
                        drawView.stroke = rand.nextFloat() * (dpWidth - 0)
                        drawView.hardRefresh()
                    }
                }
                linearLayout {
                    button("draw a pixel").onClick {
                        drawView.setPixel(rand.nextFloat() * (dip(dpWidth) - 0), rand.nextFloat() * (dip(dpWidth) - 0), refresh = true, hardRefresh = true)
                    }
                }
            }

        }
    }
}

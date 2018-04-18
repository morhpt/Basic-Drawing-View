@file:Suppress("NOTHING_TO_INLINE")

package com.morhpt.drawingview

import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.drawingView(): DrawingView = drawingView { }
inline fun ViewManager.drawingView(theme: Int = 0, init: DrawingView.() -> Unit) = ankoView({ DrawingView(it) }, theme, init)
package com.duomaker.couplelove.vatar.core.custom.listener.listenerdraw

import android.view.MotionEvent
import com.duomaker.couplelove.vatar.core.custom.DrawView


interface DrawEvent {
    fun onActionDown(tattooView: DrawView?, event: MotionEvent?)
    fun onActionMove(tattooView: DrawView?, event: MotionEvent?)
    fun onActionUp(tattooView: DrawView?, event: MotionEvent?)
}
package com.mercy.kids.component.layout.video

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.res.getResourceIdOrThrow
import com.mercy.kids.component.R
import com.mercy.kids.component.extension.getAttributes

class VideoPlayerMotionLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): MotionLayout(context, attrs, defStyleAttr) {

    private val viewRect = Rect()
    private var touchStarted = false
    private val transitionListenerList = mutableListOf<TransitionListener?>()

    private val detectTouchViewId: Int
    private lateinit var detectTouchView: View

    private val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            transitionToEnd()
            return false
        }
    })

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.VideoPlayerMotionLayout)
        detectTouchViewId = typedArray.getResourceIdOrThrow(R.styleable.VideoPlayerMotionLayout_detectTargetViewId)
        typedArray.recycle()

        initTransitionListener()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        detectTouchView = findViewById(detectTouchViewId)
    }

    private fun initTransitionListener() {
        addTransitionListener(object: SimpleTransitionListener() {
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                touchStarted = false
            }
        })
        super.setTransitionListener(object: SimpleTransitionListener() {
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                transitionListenerList.filterNotNull().forEach {
                    it.onTransitionChange(p0, p1, p2, p3)
                }
            }
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                transitionListenerList.filterNotNull().forEach {
                    it.onTransitionCompleted(p0, p1)
                }
            }
        })
    }

    override fun setTransitionListener(listener: TransitionListener?) {
        addTransitionListener(listener)
    }

    override fun addTransitionListener(listener: TransitionListener?) {
        transitionListenerList += listener
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)
        when(event.actionMasked) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                touchStarted = false
                return super.onTouchEvent(event)
            }
        }
        if(!touchStarted) {
            detectTouchView.getHitRect(viewRect)
            touchStarted = viewRect.contains(event.x.toInt(), event.y.toInt())
        }
        return touchStarted && super.onTouchEvent(event)
    }

    private open class SimpleTransitionListener : TransitionListener {
        override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) = Unit
        override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) = Unit
        override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) = Unit
        override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) = Unit
    }

}
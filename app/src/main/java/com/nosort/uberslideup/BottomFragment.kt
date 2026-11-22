package com.nosort.uberslideup

import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BottomFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            LayoutInflater.from(context).inflate(R.layout.bottom_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMotionLayoutListener()
    }

    private fun setMotionLayoutListener() {
        requireView().findViewById<MotionLayout>(R.id.bottomMotionlayout).setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, progress: Float) {
                val mainActivity = activity as MainActivity
                mainActivity.findViewById<MotionLayout>(R.id.mainMotionLayout).progress = Math.abs(progress)
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }
        })
    }

    companion object {
        fun newInstance(): Fragment =
                BottomFragment()
    }

}

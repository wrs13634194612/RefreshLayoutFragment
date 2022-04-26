package com.example.flushfragmentdemo




import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var mPaintFragment: PaintFragment
    private lateinit var mRoomFragment: RoomFragment
    private val mList: MutableList<Fragment> = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPaintFragment = PaintFragment.newInstance(0)
        mRoomFragment = RoomFragment.newInstance(1)
        mList.add(mPaintFragment)
        mList.add(mRoomFragment)
        viewpager.adapter = PaintAdapter(supportFragmentManager, mList)
        tablayout.setupWithViewPager(viewpager)
        sm_layout.setOnRefreshListener {
            mPaintFragment.getData("韩红s1")
            mRoomFragment.getData("赵信s5")
            sm_layout.finishRefresh(500)
        }
    }

}
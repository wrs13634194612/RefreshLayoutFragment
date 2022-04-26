package com.example.flushfragmentdemo


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class RoomFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_room, null)
        return view
    }

    fun getData(name: String) {
        Log.e("TAG", "RoomFragment:" + name)
    }

    companion object {
        private const val PAINT_TYPE = "type"
        private const val OIL_PAINT_TYPE = 1
        private const val PENCIL_PAINT_TYPE = 2

        fun newInstance(type: Int): RoomFragment {
            val args = Bundle()
            args.putInt(PAINT_TYPE, type)
            val fragment = RoomFragment()
            fragment.arguments = args
            return fragment
        }
    }


}
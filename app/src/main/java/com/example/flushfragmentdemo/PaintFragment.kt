package com.example.flushfragmentdemo


import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_paint.*

class PaintFragment : Fragment() {

    private var mType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = arguments
        if (bundle != null) {
            mType = bundle.getInt(PAINT_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_paint, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        val res: Resources = getResources()
        val bitmap = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher)
        image.setImageBitmap(bitmap)
    }

    fun getData(name: String) {
        Log.e("TAG", "PaintFragment:" + name)
    }

    companion object {
        private const val PAINT_TYPE = "type"
        private const val OIL_PAINT_TYPE = 1
        private const val PENCIL_PAINT_TYPE = 2

        fun newInstance(type: Int): PaintFragment {
            val args = Bundle()
            args.putInt(PAINT_TYPE, type)
            val fragment = PaintFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
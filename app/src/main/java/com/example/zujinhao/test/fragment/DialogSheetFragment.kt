package com.example.zujinhao.test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zujinhao.test.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogSheetFragment : BottomSheetDialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.dialog_bottom_sheet,container);
        return view
    }
}
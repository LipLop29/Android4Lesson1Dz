package com.example.android4lesson1dz.ui.fragments.home.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.base.BaseFlowFragment

class HomeFlowFragment : BaseFlowFragment(R.layout.fragment_home_flow) {
    override val navigationId: Int
        get() = R.id.home_host_fragment
}
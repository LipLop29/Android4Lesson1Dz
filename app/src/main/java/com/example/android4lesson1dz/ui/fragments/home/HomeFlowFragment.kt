package com.example.android4lesson1dz.ui.fragments.home

import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.base.BaseFlowFragment

class HomeFlowFragment : BaseFlowFragment(R.layout.fragment_home_flow) {
    override val navigationId: Int
        get() = R.id.home_host_fragment
}
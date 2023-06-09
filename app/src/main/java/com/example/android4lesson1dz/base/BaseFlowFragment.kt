package com.example.android4lesson1dz.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFlowFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    abstract val navigationId: Int
}
package br.com.gabrielferreira.baseclean.presentation.util.view

import android.content.res.Resources
import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.RecyclerView
import android.view.View

open class BasePaddingItemDecoration(@DimenRes offset: Int,
                                     resources: Resources,
                                     private val shouldAddTopBottomPadding: Boolean,
                                     private val shouldAddSidePadding: Boolean) : RecyclerView.ItemDecoration() {

    private val offsetInPixels = resources.getDimensionPixelSize(offset)

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State) {

        super.getItemOffsets(outRect, view, parent, state)

        val paddingInPixels = offsetInPixels

        if (shouldAddTopBottomPadding) {
            outRect.bottom = paddingInPixels
            outRect.top = paddingInPixels
        }

        if (shouldAddSidePadding) {
            outRect.left = paddingInPixels
            outRect.right = paddingInPixels
        }
    }
}
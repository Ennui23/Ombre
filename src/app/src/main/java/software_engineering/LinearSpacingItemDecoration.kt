package software_engineering

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LinearSpacingItemDecoration(
    private val spacing: Int,
    private val orientation: Int,
    private val includeEdge: Boolean
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if (includeEdge) {
            outRect.left = spacing
            outRect.right = spacing
        } else {
            outRect.left = 0
            outRect.right = 0
        }

        if (position == 0 && includeEdge) {
            outRect.top = spacing
        } else {
            outRect.top = 0
        }

        val layoutManager = parent.layoutManager as? LinearLayoutManager
        val itemCount = state.itemCount

        if (position == itemCount - 1 && includeEdge) {
            outRect.bottom = spacing
        } else {
            outRect.bottom = 0
        }
    }
}

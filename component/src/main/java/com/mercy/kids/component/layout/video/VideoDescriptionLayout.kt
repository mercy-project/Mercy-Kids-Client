package com.mercy.kids.component.layout.video

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.InsetDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mercy.kids.base.extension.dp
import com.mercy.kids.component.R
import com.mercy.kids.component.databinding.ViewVideoDescriptionBinding
import com.mercy.kids.component.extension.getAttributes

class VideoDescriptionLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val ICON_MARGIN = 4.0f
    }

    private val binding = ViewVideoDescriptionBinding.inflate(LayoutInflater.from(context), this, true)

    @MenuRes var optionsMenuResId: Int = -1
    var menuItemClickListener: PopupMenu.OnMenuItemClickListener? = null

    var title: String = ""
        set(value) {
            field = value
            binding.videoTitle.text = value
        }

    var metadata: String = ""
        set(value) {
            field = value
            binding.videoMetadata.text = value
        }

    var channelThumbnail: String = ""
        set(value) {
            field = value
            Glide.with(context)
                .load(value)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.channelProfileImage)
                .clearOnDetach()
        }

    var onChannelThumbnailClicked: View.OnClickListener? = null
        set(value) {
            field = value
            value?.let { binding.channelProfileImage.setOnClickListener(it) }
        }

    init {
        setPadding(0, 12.dp(context), 0, 12.dp(context))
        setData(attrs)

        binding.optionsButton.setOnClickListener {
            showMenu()
        }
    }

    private fun setData(attributeSet: AttributeSet?) = context.getAttributes(R.styleable.VideoDescriptionLayout, attributeSet) {
        optionsMenuResId = it.getResourceId(R.styleable.VideoDescriptionLayout_additionOptionsMenu, -1)
    }

    @SuppressLint("RestrictedApi")
    private fun showMenu() {
        if (optionsMenuResId == -1) {
            return
        }
        val popup = PopupMenu(context, binding.optionsButton)
        popup.menuInflater.inflate(optionsMenuResId, popup.menu)

        if (menuItemClickListener != null) {
            popup.setOnMenuItemClickListener(menuItemClickListener)
        }

        if (popup.menu is MenuBuilder) {
            val menuBuilder = popup.menu as MenuBuilder
            menuBuilder.setOptionalIconsVisible(true)

            for (item in menuBuilder.visibleItems) {
                val iconMarginPx = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, ICON_MARGIN.dp(context), resources.displayMetrics
                ).toInt()

                if (item.icon != null) {
                    item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0)
                }
            }
            popup.show()
        }
    }

}
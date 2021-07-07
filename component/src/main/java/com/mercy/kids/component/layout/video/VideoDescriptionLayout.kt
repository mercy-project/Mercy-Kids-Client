package com.mercy.kids.component.layout.video

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.mercy.kids.base.extension.dp
import com.mercy.kids.component.databinding.ViewVideoDescriptionBinding

class VideoDescriptionLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewVideoDescriptionBinding.inflate(LayoutInflater.from(context), this, true)

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

    init {
        setPadding(0, 12.dp(context), 0, 12.dp(context))
    }

}
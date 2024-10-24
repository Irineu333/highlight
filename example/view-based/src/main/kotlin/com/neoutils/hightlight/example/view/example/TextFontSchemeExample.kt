package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.neoutils.highlight.core.extension.highlight
import com.neoutils.highlight.view.extension.textFont
import com.neoutils.highlight.view.extension.toSpannedString
import com.neoutils.hightlight.example.view.R

class TextFontSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(context, attr) {
    init {
        text = highlight {
            textFont {
                fully(
                    regex = "font",
                    checkNotNull(
                        ResourcesCompat.getFont(
                            context,
                            R.font.pacifico_regular
                        )
                    )
                )
            }
        }.toSpannedString(
            text = "Example of font style."
        )
    }
}
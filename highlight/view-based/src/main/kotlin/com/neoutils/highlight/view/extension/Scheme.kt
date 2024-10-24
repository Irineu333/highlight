package com.neoutils.highlight.view.extension

import android.graphics.Typeface
import android.text.ParcelableSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.view.scheme.BackgroundColorScheme
import com.neoutils.highlight.view.scheme.TextColorScheme
import com.neoutils.highlight.view.scheme.TextFontScheme
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.span.TextFontSpan
import com.neoutils.highlight.view.util.UiStyle

fun <T : Any> Scheme<T>.toParcelableSpans(): List<ParcelableSpan?> {

    return when (this) {
        is BackgroundColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                BackgroundColorSpan(it.colorInt)
            }
        }

        is TextColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                ForegroundColorSpan(it.colorInt)
            }
        }

        is TextStyleScheme -> {
            match.values.map {

                if (it == null) return@map null

                StyleSpan(
                    when (it) {
                        UiStyle.BOLD -> Typeface.BOLD
                        UiStyle.ITALIC -> Typeface.ITALIC
                        UiStyle.BOLD_ITALIC -> Typeface.BOLD_ITALIC
                    }
                )
            }
        }

        is TextFontScheme -> {
            match.values.map {
                TextFontSpan(
                    typeface = it ?: return@map null
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}

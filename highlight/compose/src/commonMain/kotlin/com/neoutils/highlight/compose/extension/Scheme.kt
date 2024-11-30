package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.ScriptScheme
import com.neoutils.highlight.core.scheme.TextColorScheme

fun <T : Any> Scheme<T>.toSpanStyle(): Map<Int, SpanStyle> {

    return when (this) {

        is SpanStyleScheme -> matcher.matches

        is TextColorScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                SpanStyle(
                    color = uiColor.toColor()
                )
            }
        }

        is BackgroundColorScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                SpanStyle(
                    background = uiColor.toColor()
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}

fun List<Scheme<*>>.resolveScript(text: String): List<Scheme<*>> {

    val schemes = mutableListOf<Scheme<*>>()

    for (scheme in this) {

        if (scheme is ScriptScheme) {

            for (result in text.matchAll(scheme.regex.pattern)) {

                val match = scheme.matcher.matches[0] ?: continue

                schemes.addAll(
                    Highlight {
                        match(result)
                    }.schemes
                )
            }

            continue
        }

        schemes.add(scheme)
    }

    return schemes
}
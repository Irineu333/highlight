package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.util.UiStyle

class TextStyleScope internal constructor() :
    SchemeScope<UiStyle, TextStyleScheme>() {

    override fun addScheme(
        regex: Regex,
        matcher: Matcher<UiStyle>,
        range: IntRange?
    ) {
        builder.add(
            TextStyleScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}
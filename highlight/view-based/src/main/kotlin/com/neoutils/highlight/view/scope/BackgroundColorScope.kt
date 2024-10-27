package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.scheme.BackgroundColorScheme
import com.neoutils.highlight.view.util.UiColor

class BackgroundColorScope internal constructor() :
    SchemeScope<UiColor, BackgroundColorScheme>() {

    override fun match(
        regex: String,
        match: Match<UiColor>
    ) {
        builder.add(
            BackgroundColorScheme(
                regex.toRegex(),
                match
            )
        )
    }
}
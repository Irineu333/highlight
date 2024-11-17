package com.neoutils.highlight.core

import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor

data class TextColorScheme(
    override val regex: Regex,
    override val match: Match<UiColor>,
) : Scheme<UiColor>
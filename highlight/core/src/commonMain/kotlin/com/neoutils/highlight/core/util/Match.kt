package com.neoutils.highlight.core.util

/**
 * Represents a match, where index 0 corresponds to the full match,
 * and subsequent indices represent individual groups.
 */
data class Match<T : AnyLetter>(
    val matches: Map<Int, T>
) {

    companion object {

        /**
         * Creates a Match instance from a list of all matches.
         *
         * This method allows specifying matches manually, where each pair consists of an index
         * (0 for the full match, 1 and above for groups) and the corresponding match value.
         *
         * @param matches Pairs representing the index and value of each match.
         * @return A Match instance containing the provided matches.
         */
        fun <T : AnyLetter> all(
            vararg matches: Pair<Int, T>
        ) = Match(
            matches = mapOf(*matches)
        )

        /**
         * Creates a Match instance representing only the full match, without groups.
         *
         * @param value The value corresponding to the full match.
         * @return A Match instance containing only the full match.
         */
        fun <T : AnyLetter> fully(value: T) = Match(
            matches = mapOf(0 to value)
        )

        /**
         * Creates a Match instance from a list of group values, excluding the full match.
         *
         * The full match is not included, and groups are indexed starting at 1.
         *
         * @param groups The values of the groups, which can be null.
         * @return A Match instance containing the provided groups.
         */
        fun <T : AnyLetter> groups(vararg groups: T?) = Match<T>(
            matches = buildMap {
                groups.forEachIndexed { index, group ->
                    group?.let { put(index + 1, it) }
                }
            }
        )
    }
}

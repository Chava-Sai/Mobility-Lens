package edu.bu.saichava.mobilitylens

data class MobilityDimension(
    val titleResId: Int,
    val descriptionResId: Int,
    val implicationResId: Int
)

val mobilityDimensions = listOf(
    MobilityDimension(
        titleResId = R.string.dimension_input_title,
        descriptionResId = R.string.dimension_input_description,
        implicationResId = R.string.dimension_input_implication
    ),
    MobilityDimension(
        titleResId = R.string.dimension_screen_title,
        descriptionResId = R.string.dimension_screen_description,
        implicationResId = R.string.dimension_screen_implication
    ),
    MobilityDimension(
        titleResId = R.string.dimension_lifecycle_title,
        descriptionResId = R.string.dimension_lifecycle_description,
        implicationResId = R.string.dimension_lifecycle_implication
    ),
    MobilityDimension(
        titleResId = R.string.dimension_context_title,
        descriptionResId = R.string.dimension_context_description,
        implicationResId = R.string.dimension_context_implication
    ),
    MobilityDimension(
        titleResId = R.string.dimension_usage_title,
        descriptionResId = R.string.dimension_usage_description,
        implicationResId = R.string.dimension_usage_implication
    ),
    MobilityDimension(
        titleResId = R.string.dimension_security_title,
        descriptionResId = R.string.dimension_security_description,
        implicationResId = R.string.dimension_security_implication
    )
)

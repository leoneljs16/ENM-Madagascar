package mg.enm.maths.data

data class Track(
    val id: String,
    val title: String,
    val exam: String,
    val verified: Boolean,
    val chapters: List<String>
)

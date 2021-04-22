package academy.learnprogramming.redditviewer.model

data class Data(
    val after: String,
    val before: Any,
    val children: List<Children>,
    val dist: Int,
    val modhash: String
)
package net.versteht.factreply.model

data class Fact (
    val answer: String,
    val category: Category,
    val sourceLink: List<String>
)


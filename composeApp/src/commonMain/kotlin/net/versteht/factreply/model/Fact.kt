package net.versteht.factreply.model

data class Fact (
    val reply: String,
    val categories: List<String>,
    val sources: List<String>
)


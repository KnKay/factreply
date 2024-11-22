package net.versteht.factreply.model

interface FactRepository {
    fun allFacts(): List<Fact>
    fun addFact(fact: Fact)
    fun removeFact(name: String): Boolean
    fun factsByCategory(category: String): List<Fact>
}

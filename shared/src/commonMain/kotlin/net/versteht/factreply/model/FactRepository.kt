package net.versteht.factreply.model

interface FactRepository {
    suspend fun allFacts(): List<Fact>
    suspend fun addFact(fact: Fact)
    suspend fun removeFact(name: String): Boolean
    suspend fun factsByCategory(category: String): List<Fact>
}

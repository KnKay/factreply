package net.versteht.factreply.database

import net.versteht.factreply.model.Fact
import net.versteht.factreply.model.FactRepository

class FactRepositoryJdbc : FactRepository {
    suspend override fun allFacts(): List<Fact> {
        TODO("Not yet implemented")
    }

    suspend override fun addFact(fact: Fact) {
        TODO("Not yet implemented")
    }

    suspend override fun removeFact(name: String): Boolean {
        TODO("Not yet implemented")
    }

    suspend override fun factsByCategory(category: String): List<Fact> {
        TODO("Not yet implemented")
    }
}
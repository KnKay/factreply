package net.versteht.factreply.database

import net.versteht.factreply.model.Category
import net.versteht.factreply.model.Fact
import net.versteht.factreply.model.FactRepository

class FactRepositoryJdbc : FactRepository {
    suspend override fun allFacts(): List<Fact> = suspendTransaction {
        TODO("Not yet implemented")
        FactDAO.all().map(::daoToFact)
    }

    suspend override fun addFact(fact: Fact) : Unit = suspendTransaction {
        FactDAO.new{
            answer = fact.answer
            category = CategoryDAO.new {
                name = fact.category.name
            }
            sourceLink = fact.sourceLink
        }
    }

    suspend override fun removeFact(name: String): Boolean {
        TODO("Not yet implemented")
    }

    suspend override fun factsByCategory(category: String): List<Fact> = suspendTransaction {
        val cat = CategoryDAO.
            find{ CategoryTable.name eq category }
            .limit(1)
            .first()
        FactDAO
            .find{ FactTable.category  eq cat.id}
            .map(::daoToFact)
    }
}
package net.versteht.factreply.model

import net.versteht.factreply.database.*
import org.jetbrains.exposed.sql.transactions.transaction

class CategoryRepositoryJdbc : CategoryRepository {
    override suspend fun allCategories(): List<Category> = suspendTransaction {
        CategoryDAO.all().map(::daoToModel)
    }

    override suspend fun addCategory(category: Category): Unit = suspendTransaction {
        CategoryDAO.new {
            name = category.name
        }
    }

    override suspend fun getCategoryByName(name: String): Category? = suspendTransaction {
        CategoryDAO
            .find { (CategoryTable.name eq name) }
            .limit(1)
            .map(::daoToModel)
            .firstOrNull()
    }

    override fun allCategoriesTest(): List<Category> {
        return transaction {
            CategoryDAO.all().map(::daoToModel)
        }
    }

}
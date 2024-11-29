package net.versteht.factreply.database

import net.versteht.factreply.model.Category
import net.versteht.factreply.model.CategoryRepository
import org.jetbrains.exposed.sql.transactions.transaction

class CategoryRepositoryJdbc : CategoryRepository {
    override suspend fun allCategories(): List<Category> = suspendTransaction {
        CategoryDAO.all().map(::daoToCategory)
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
            .map(::daoToCategory)
            .firstOrNull()
    }

    override fun allCategoriesTest(): List<Category> {
        return transaction {
            CategoryDAO.all().map(::daoToCategory)
        }
    }

}
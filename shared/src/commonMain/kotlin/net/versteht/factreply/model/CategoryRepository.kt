package net.versteht.factreply.model

interface CategoryRepository {
    suspend fun allCategories(): List<Category>
    suspend fun addCategory(name: String)
    suspend fun getCategoryByName(name: String): Category
}
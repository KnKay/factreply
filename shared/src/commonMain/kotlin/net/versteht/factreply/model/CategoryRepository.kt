package net.versteht.factreply.model

interface CategoryRepository {
    suspend fun allCategories(): List<Category>
    suspend fun addCategory(category: Category)
    suspend fun getCategoryByName(name: String): Category?
    fun allCategoriesTest(): List<Category>
}
package net.versteht.factreply.model

interface CategoryRepository {
    fun allCategories(): List<Category>
    fun addCategory(name: String)
}
package net.versteht.factreply.model

class CategoryRepositoryJdbc : CategoryRepository {
    override suspend fun allCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun addCategory(name: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryByName(name: String): Category {
        TODO("Not yet implemented")
    }
}
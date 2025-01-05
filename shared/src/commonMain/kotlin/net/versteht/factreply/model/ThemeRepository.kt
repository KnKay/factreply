package net.versteht.factreply.model

interface ThemeRepository {
    suspend fun allThemes(): List<Category>
    suspend fun addTheme(category: Category)
    suspend fun getThemeByName(name: String): Category?
}
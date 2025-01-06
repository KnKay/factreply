package net.versteht.factreply.model

interface ThemeRepository {
    suspend fun allThemes(): List<Theme>
    suspend fun addTheme(theme: Theme)
    suspend fun getThemeByName(name: String): Theme?
}
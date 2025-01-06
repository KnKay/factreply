package net.versteht.factreply.database

import net.versteht.factreply.model.Theme
import net.versteht.factreply.model.ThemeRepository


class ThemeRepositoryJdbc : ThemeRepository {
    override suspend fun allThemes(): List<Theme> = suspendTransaction {
        ThemeDAO.all().map(::daoToTheme)
    }

    override suspend fun addTheme(theme: Theme) {
        ThemeDAO.new {
            name = theme.name
        }
    }


    override suspend fun getThemeByName(name: String): Theme? = suspendTransaction {
        ThemeDAO
            .find { (ThemeTable.name eq name) }
            .limit(1)
            .map(::daoToTheme)
            .firstOrNull()
    }

}
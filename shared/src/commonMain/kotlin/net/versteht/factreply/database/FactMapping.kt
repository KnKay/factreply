package net.versteht.factreply.database

import net.versteht.factreply.model.Category
import net.versteht.factreply.model.Fact
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object FactTable: IntIdTable("fact") {
    val answer = varchar("answer", 150)
    val tldr = varchar("tldr", 50)
    val sourceLink = varchar("sourceLink", 50)
    val category = reference("category", CategoryTable)
    val theme = reference("theme", ThemeTable)
}

class FactDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<FactDAO>(FactTable)

    var answer by FactTable.answer
    var sourceLink by  FactTable.sourceLink
    var category by CategoryDAO referencedOn  FactTable.category
    var theme by ThemeDAO referencedOn  FactTable.theme
    var tldr by FactTable.tldr
}

fun daoToFact(dao: FactDAO) = Fact(
    dao.answer,
    daoToCategory(dao.category),
    dao.sourceLink,
    daoToTheme(dao.theme),
    dao.tldr
)

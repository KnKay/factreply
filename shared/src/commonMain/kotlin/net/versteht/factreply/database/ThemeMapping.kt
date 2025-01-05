package net.versteht.factreply.database

// https://ktor.io/docs/server-integrate-database.html#create-mapping
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import net.versteht.factreply.model.Theme

object ThemeTable : IntIdTable("Theme") {
    val name = varchar("name", 50).uniqueIndex()
}

    class ThemeDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ThemeDAO>(ThemeTable)

    var name by ThemeTable.name
}

fun daoToTheme(dao: ThemeDAO) = Theme(
    dao.name,
)
package net.versteht.factreply.database

// https://ktor.io/docs/server-integrate-database.html#create-mapping
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import net.versteht.factreply.model.Category

object CategoryTable : IntIdTable("category") {
    val name = varchar("name", 50).uniqueIndex()
}

    class CategoryDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CategoryDAO>(CategoryTable)

    var name by CategoryTable.name
}

fun daoToCategory(dao: CategoryDAO) = Category(
    dao.name,
)
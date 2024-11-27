package net.versteht.factreply.database

// https://ktor.io/docs/server-integrate-database.html#create-mapping
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import net.versteht.factreply.model.Category

object CategoryTable : IntIdTable("category") {
    val name = varchar("name", 50)
}

class CategoryDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CategoryDAO>(CategoryTable)

    var name by CategoryTable.name
}

fun daoToModel(dao: CategoryDAO) = Category(
    dao.name,
)
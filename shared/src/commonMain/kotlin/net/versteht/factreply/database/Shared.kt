package net.versteht.factreply.database

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object FactTable: IntIdTable("fact") {
    val answer = varchar("answer", 50)
    val sourceLink = varchar("sourceLink", 50)
    val category = reference("category", CategoryTable)
}

suspend fun <T> suspendTransaction(block: Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, statement = block)

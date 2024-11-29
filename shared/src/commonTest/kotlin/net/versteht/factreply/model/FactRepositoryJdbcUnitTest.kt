package net.versteht.factreply.model

import kotlinx.coroutines.test.runTest
import net.versteht.factreply.database.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

class FactRepositoryJdbcUnitTest {
    private var dut = FactRepositoryJdbc()

    @Before
    fun setup() {
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(CategoryTable)
            SchemaUtils.create(FactTable)
            CategoryTable.insert {
                it[name] = "training"
            }
            FactDAO.new {
                answer = "some super nice reply"
                sourceLink = "the internet"
                category = CategoryDAO.new {
                    name = "test"
                }
            }
        }
    }

    @Test
    fun listAll(): Unit = runTest {
        val data = dut.allFacts()
        assertEquals(data, data)
    }
}
package net.versteht.factreply.model

import net.versteht.factreply.database.CategoryTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

import kotlin.test.Test
import kotlinx.coroutines.test.runTest
import net.versteht.factreply.database.CategoryRepositoryJdbc
import org.junit.After
import org.junit.Before
import java.io.File
import kotlin.test.assertEquals

class CategoryRepositoryJdbcIntegrationTest {
    var dut = CategoryRepositoryJdbc()
    @Before
    fun setup() {
        // Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
        Database.connect("jdbc:sqlite:./data.db", "org.sqlite.JDBC")
        transaction{
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(CategoryTable)
            val taskId = CategoryTable.insert {
                it[name] = "training"
            }
        }
    }

    @After
    fun tear_down() {
        val success = File("./data.db").deleteRecursively()
    }

    @Test
    fun listAll(){

        val res = dut.allCategoriesTest()
        println(res)
    }

    @Test
    fun dataShouldBeHelloWorld(): Unit = runTest {
        val data = dut.allCategories()
        assertEquals(data, data)
    }
}

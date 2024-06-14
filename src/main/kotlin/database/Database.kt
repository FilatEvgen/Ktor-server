package database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {

    private const val URL = "jdbc:postgresql://localhost:5432/game_list"
    private const val USERNAME = "postgres"
    private const val PASSWORD = "12345q"

    fun getConnection(): Connection? {
        try {
            Class.forName("org.postgresql.Driver")
            return DriverManager.getConnection(URL, USERNAME, PASSWORD)
        } catch (e: SQLException) {
            println("Error connecting to database: $e")
            return null
        }
    }
}
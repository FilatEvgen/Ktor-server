package database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {

    private const val url = "URL"
    private const val username = "USERNAME"
    private const val password= "PASSWORD"

    fun getConnection(): Connection? {
        try {
            Class.forName("org.postgresql.Driver")
            return DriverManager.getConnection(url, username, password)
        } catch (e: SQLException) {
            println("Error connecting to database: $e")
            return null
        }
    }
}
package to.grindelf.authorizator.dataprocessor

import to.grindelf.authorizator.domain.User
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

class DataBaseOperator(
    private val databaseUrl: String
) {

    companion object {
        private const val TABLE_NAME: String = "users"
    }

    /**
     * Creates a database table if it does not exist.
     */
    fun createUsersTable() {
        val connection: Connection = DriverManager.getConnection(databaseUrl)

        connection.use {
            val statement: Statement = it.createStatement()
            statement.executeUpdate(
                """
                    create table if not exists '$TABLE_NAME'(
                        id integer primary key autoincrement,
                        login text not null,
                        password text not null
                    )
                """.trimIndent()
            )
        }
    }

    /**
     * Inserts a new user entry into the database.
     * @param login new user login
     * @param password new user password
     */
    fun insertUser(login: String, password: String) {
        val connection: Connection = DriverManager.getConnection(databaseUrl)

        connection.use {
            val statement: Statement = it.createStatement()
            statement.executeUpdate(
                """
                    insert into '$TABLE_NAME' (login, password)
                    values ('$login', '$password')
                """.trimIndent()
            )
        }
    }

    /**
     * Validates user based on comparing provided data and data from database.
     * @param login provided user login
     * @param providedPassword provided user password
     * @return true if user is present in database
     * and entered correct authorization data,
     *  false otherwise
     */
    fun validator(login: String, providedPassword: String): Boolean {
        var userIsValid = false
        val user = getUser(login)
        if (user.isNotNull()) {
            userIsValid = providedPassword == user.password
        }

        return userIsValid
    }


    /**
     * Gets user by login.
     * @param login provided user login
     * @return [User] instance based on provided [login]
     * or a null-user if there is no such user in database
     */
    private fun getUser(login: String): User {
        if (login.contains("'")) login.replace("'", "")

        val connection: Connection = DriverManager.getConnection(databaseUrl)

        var user = User()
        connection.use {
            val statement: Statement = it.createStatement()
            val results = statement.executeQuery(
                """
                    select * 
                    from '$TABLE_NAME' 
                    where login = '$login'
                """.trimIndent()
            )
            if (results.next()) {
                user = User(
                    results.getInt("id"),
                    results.getString("login"),
                    results.getString("password")
                )
            }
        }

        return user
    }
}
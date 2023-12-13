package to.grindelf.authorizator.dataprocessor

object Processor {
    private const val DATABASE_PATH: String = "src/main/resources/databases/diary.db"
    private const val DATABASE_URL: String = "jdbc:sqlite:$DATABASE_PATH"
    const val USERS_TABLE_NAME: String = "users"

    fun createDataBase() {
        val operator = DataBaseOperator(DATABASE_URL)
        operator.createUsersTable()
    }

    fun insertUser(login: String, password: String) {
        val operator = DataBaseOperator(DATABASE_URL)
        operator.insertUser(login, password)
    }

    fun authorizeUser(login: String, providedPassword: String): String {
        val operator = DataBaseOperator(DATABASE_URL)
        val isValid = operator.validator(login, providedPassword)

        return when (isValid) {
            true -> "User authorized successfully"
            false -> "Invalid login or password"
        }
    }
}
package to.grindelf.authorizator.dataprocessor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import to.grindelf.authorizator.Autorizator
import java.io.File

class DataBaseOperatorTest {

    companion object {
        private const val DATABASE_PATH: String = "src/test/resources/databases/users-test.db"
        private const val DATABASE_URL: String = "jdbc:sqlite:$DATABASE_PATH"
    }


    @Test
    fun `GIVEN database url WHEN created THEN created correctly`() {
        val dataBaseOperator = DataBaseOperator(DATABASE_URL)

        if (!File(DATABASE_PATH).exists()) dataBaseOperator.createTable()
    }

    @Test
    fun `GIVEN login and password WHEN authorized THEN authorized correctly`() {
        val dataBaseOperator = DataBaseOperator(DATABASE_URL)

        val newUserLogin = "exampleUser"
        val newUserPassword = "examplePassword"
        dataBaseOperator.insertUser(newUserLogin, newUserPassword)
    }

    @Test
    fun `GIVEN login WHEN authorized THEN authorization is successful`() {
        val dataBaseOperator = DataBaseOperator(DATABASE_URL)

        val loginAttempt = "exampleUser"
        val passwordAttempt = "examplePassword"

        assertThat(dataBaseOperator.validator(loginAttempt, passwordAttempt)).isTrue()
    }

    @Test
    fun `GIVEN wrong login WHEN authorized THEN authorization is failed`() {
        val dataBaseOperator = DataBaseOperator(DATABASE_URL)

        val loginAttempt = "wrongLogin"
        val passwordAttempt = "examplePassword"

        assertThat(dataBaseOperator.validator(loginAttempt, passwordAttempt)).isFalse()
    }

    @Test
    fun `GIVEN wrong password WHEN authorized THEN authorization is failed`() {
        val dataBaseOperator = DataBaseOperator(DATABASE_URL)

        val loginAttempt = "exampleUser"
        val passwordAttempt = "wrongPassword"

        assertThat(dataBaseOperator.validator(loginAttempt, passwordAttempt)).isFalse()
    }
}
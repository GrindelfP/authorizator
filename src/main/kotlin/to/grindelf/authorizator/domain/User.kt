package to.grindelf.authorizator.domain

data class User(
    val id: Int,
    val login: String,
    val password: String
) {

    companion object {
        private const val NULL_USER_ID: Int = -1
        private const val NULL_USER_LOGIN: String = "noname"
        private const val NULL_USER_PASSWORD: String = "nopass"
    }

    constructor() : this(NULL_USER_ID, NULL_USER_LOGIN, NULL_USER_PASSWORD)

    fun isNotNull(): Boolean =
        this.id != NULL_USER_ID && this.login != NULL_USER_LOGIN && this.password != NULL_USER_PASSWORD
}

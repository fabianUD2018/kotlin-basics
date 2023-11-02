import java.time.Instant

data class CreateUserOutput(
    val userId: String,
    val userName: String,
    val email: String,
    val created: Instant,
    val lastModified: Instant
) {

}
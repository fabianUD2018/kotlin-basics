import java.util.UUID
//interfaces can be multiple extended
data class Course(val id:String )

interface CourseRepository {
    var isCoursePersisted:Boolean

    fun getById(id:String):Course

    fun save(course: Course): String{
        println(course)
        return course.id
    }
}

class SqlCourseRepository : CourseRepository {
    override var isCoursePersisted: Boolean = false

    override fun getById(id: String): Course {
        return Course(id)
    }

    override fun save(course: Course): String {
        isCoursePersisted=true
        return super.save(course)
    }

}

interface A {
    fun doSomething(){
        println("doing something in a")
    }
}


interface B {
    fun doSomething(){
        println("doing something in b")
    }
}

class AB :A, B{
    override fun doSomething() {
        super<A>.doSomething()
    }
}


fun main(){
    val sqlCourseRepository: SqlCourseRepository = SqlCourseRepository()
    println(sqlCourseRepository.getById("something"))
    val course: Course = Course("another")
    println( sqlCourseRepository.save(course))

}
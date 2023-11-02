class Student (name:String) : User(name) {
    override fun login() {
        super.login()
        println("Login a student with id $STATIC_STUDENT_ID")
    }

}

class Instructor (name:String) : User(name){
    override var isSuperUser: Boolean = true
    override fun login() {
        super.login()
        println("Login a instructor and it is super user $isSuperUser")
    }

}

fun main(){
    var student = Student("Fabian")
    var instructor = Instructor("Teacher")

    if (User.STATIC_STUDENT_ID.isNotEmpty()){
        println("users are static students and belongs to the department ${User.staticDepartment()}")
    }
    student.login()
    instructor.login()
}
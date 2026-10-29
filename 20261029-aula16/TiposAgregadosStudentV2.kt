fun main() {

    // Criação das unidades curriculares. Cada Course é criado uma só vez e
    // depois partilhado (a mesma referência) pelos CourseGrade de todos os alunos
    val c1: Course = Course(1, "Cálculo Diferencial e Integral")
    val c2: Course = Course(2, "Tópicos de Matemática Discreta")
    val c3: Course = Course(3, "Lógica e Sistemas Digitais")
    val c4: Course = Course(4, "Programação")
    val c5: Course = Course(5, "Electrónica")

    // Aluno com número 1. O terceiro argumento é uma lista imutável (listOf)
    // de CourseGrade, em que cada elemento associa uma UC a uma nota
    val st1: Student = Student(1, "Pedro", listOf(
        CourseGrade(c1, 12),
        CourseGrade(c2, 14),
        CourseGrade(c3, 12),
        CourseGrade(c4, 11),
        CourseGrade(c5, 15)
    ))

    // Aluna com número 2, com notas às mesmas cinco UC
    val st2: Student = Student(2, "Inês", listOf(
        CourseGrade(c1, 11),
        CourseGrade(c2, 14),
        CourseGrade(c3, 14),
        CourseGrade(c4, 17),
        CourseGrade(c5, 12)
    ))

    // Aluno com número 3, com notas às mesmas cinco UC
    val st3: Student = Student(3, "João", listOf(
        CourseGrade(c1, 17),
        CourseGrade(c2, 12),
        CourseGrade(c3, 14),
        CourseGrade(c4, 11),
        CourseGrade(c5, 14)
    ))

    // Lista (imutável) com os três alunos. O tipo List<Student> está explícito,
    // mas o compilador também o conseguiria inferir
    val students: List<Student> = listOf(st1, st2, st3)

    // O println usa o toString() gerado pelas data classes, que é encadeado:
    // cada Student mostra os seus CourseGrade, e cada um destes mostra o seu Course.
    // Sai tudo numa só linha, no formato:
    // [Student(number=1, name=Pedro, courseGrades=[CourseGrade(course=Course(id=1,
    // name=Cálculo Diferencial e Integral), grade=12), ...]), Student(...), ...]
    //println(students)

    //saber a nota do aluno 1 (st1) a PG
    //filter retorna sempre uma lista com 0 ou mais elementos
    // sobre o aluno 1 (st1) vou à sua lista de courseGrades e filtro o course com id=4 (PG).
    // como o filter retorna uma lista, tenho de selecionar o primeiro elemento da lista
    // e depois aceder à propriedade grade (para saber a nota)
    //val st1GradePG: Int = st1.courseGrades.filter{it.course.id==4}[0].grade
    //val st1GradePG: Int = st1.courseGrades.filter{it.course.id==4}.first().grade
    val st1GradePG: Int = st1.courseGrades.first{it.course.id==4}.grade
    println(st1GradePG)

    // para saber a média do aluno 1, uso o objeto st1 e acedo à propriedade courseGrades
    // e transformo para obter uma lista com todas as notas. Depois basta fazer average()
    val st1Average: Double = st1.courseGrades.map{it.grade}.average()
    println(st1Average)

    // para saber a média de todas as notas de pg
    // fica para vocês fazerem

}

// Representa uma unidade curricular: identificador e nome.
// Sendo data class, tem equals(), hashCode(), toString() e copy() gerados
data class Course(val id: Int, val name: String)

// Associa uma UC a uma nota. Guarda uma referência para o Course, não uma cópia
data class CourseGrade(val course: Course, val grade: Int)

// Representa um aluno: número, nome e lista das suas notas.
// Duas instâncias de Student são iguais (==) se todas as propriedades
// forem iguais, incluindo o conteúdo da lista de notas
data class Student(val number: Int, val name: String, val courseGrades: List<CourseGrade>)
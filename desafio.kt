sealed class Nivel(val descricao: String) {
    object BASICO : Nivel("Nível básico")
    object INTERMEDIARIO : Nivel("Nível intermediário")
    object AVANCADO : Nivel("Nível avançado")
}

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} se matriculou na formação $nome.")
    }
}

fun main() {
    val usuario1 = Usuario("João", "joao@gmail.com")
    val usuario2 = Usuario("Maria", "maria@hotmail.com")
    
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 30)
    val conteudo2 = ConteudoEducacional("Funções e Classes", 40)
    val conteudo3 = ConteudoEducacional("Collections e Lambdas", 50)
    
    val formacao1 = Formacao("Kotlin Básico", listOf(conteudo1, conteudo2, conteudo3)).apply {
        matricular(usuario1)
        matricular(usuario2)
    }
    
    
    fun exibirNivel(nivel: Nivel) {
        when (nivel) {
            is Nivel.BASICO -> println("Este conteúdo é ${nivel.descricao} e tem uma duração média de 30 minutos.")
            is Nivel.INTERMEDIARIO -> println("Este conteúdo é ${nivel.descricao} e tem uma duração média de 40 minutos.")
            is Nivel.AVANCADO -> println("Este conteúdo é ${nivel.descricao} e tem uma duração média de 50 minutos.")
        }
    }
    
    exibirNivel(Nivel.BASICO)
    exibirNivel(Nivel.AVANCADO)
}

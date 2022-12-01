package co.tiagoaguiar.tutorial.gmaps

fun main() {
    val mensagem = EmailBuilder().de("Plant World").assunto("Bem vindo").build()
    println(mensagem)
}

class EmailBuilder() {
    private var email: Email = Email()

    fun build(): Email {
        return email
    }

    fun de(de: String): EmailBuilder {
        email.de = de
        return this
    }

    fun para(para: String): EmailBuilder {
        email.para = para
        return this
    }

    fun assunto(assunto: String): EmailBuilder {
        email.assunto = assunto
        return this
    }

    fun mensagem(mensagem: String): EmailBuilder {
        email.mensagem = mensagem
        return this
    }
}

data class Email(
    var de: String = "plantwolrd.com",
    var para: String = "usuarioplantwolrd.com",
    var cc: List<String> = listOf(),
    var assunto: String = "vem tranquilo",
    var mensagem: String = "Bem vindo ao Plant World aqui salvaremos o planeta",
    var anexos: List<java.io.File> = listOf()
)
package br.com.zup.autor

class DetalhesAutorResponse(autor: Autor) {

    val id: Long = autor.id
    val nome: String = autor.nome
    val descricao: String = autor.descricao
    val email: String = autor.email



}
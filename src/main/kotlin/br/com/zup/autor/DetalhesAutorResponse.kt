package br.com.zup.autor

class DetalhesAutorResponse(autor: Autor) {

    val nome: String = autor.nome
    val descricao: String = autor.descricao


}
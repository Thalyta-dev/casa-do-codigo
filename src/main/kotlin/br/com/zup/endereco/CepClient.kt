package br.com.zup.endereco

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import java.net.http.HttpResponse


@Client("https://viacep.com.br/ws")
interface CepClient {

    @Get("/{cep}/json/")
    fun recebeCep(@PathVariable cep: String ): EnderecoClient
}
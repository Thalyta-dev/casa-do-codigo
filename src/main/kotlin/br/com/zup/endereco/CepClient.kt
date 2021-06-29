package br.com.zup.endereco

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client


@Client("https://viacep.com.br/ws")
interface CepClient {

    @Get("/{cep}/xml/")
    @Consumes(MediaType.APPLICATION_XHTML)
    fun recebeCep(@PathVariable cep: String ): EnderecoClient
}
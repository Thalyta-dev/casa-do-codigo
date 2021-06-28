package br.com.zup.endereco

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class EnderecoRequest(

    val enderecoClient: EnderecoClient

) {

    @field: NotEmpty
    val logradouro = enderecoClient.logradouro
    @field: NotEmpty
    val localidade = enderecoClient.localidade
    @field: NotEmpty
    val uf = enderecoClient.uf
    @field: NotEmpty
    @field:Size(min = 8, max = 8)
    val cep = enderecoClient.cep

    fun toModel(): Endereco{
        return Endereco(
            logradouro = this.logradouro,
            localidade = this.localidade,
            uf = this.uf,
            cep = this.cep
        )
    }
}



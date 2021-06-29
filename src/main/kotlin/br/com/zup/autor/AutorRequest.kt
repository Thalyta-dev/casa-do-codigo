package br.com.zup.autor

import br.com.zup.validacao.UniqueEmail
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class AutorRequest(

    @field: NotBlank val nome: String,
    @field:UniqueEmail  @field:Email @field: NotBlank val email: String,
    @field: NotBlank @field:Size(max = 400) var descricao: String


) {

    fun toAutor(): Autor{

        return Autor(
            nome, email, descricao
        )
    }

}

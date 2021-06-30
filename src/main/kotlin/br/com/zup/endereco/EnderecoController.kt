package br.com.zup.endereco

import br.com.zup.autor.AutorRespository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional

@Validated
@Controller("/autores")
class EnderecoController(
    val autorRespository: AutorRespository,
    val consultaCepClient: CepClient
) {


    @Transactional
    @Post("/{idAutor}/endereco")
    fun cadastraEndero(cep: String, @PathVariable idAutor: Long): HttpResponse<Any> {

        val possivelAutor = autorRespository.findById(idAutor)

        if (possivelAutor.isEmpty) return HttpResponse.notFound()

        val autor = possivelAutor.get()


        val endereco = EnderecoRequest(consultaCepClient.recebeCep(cep))
        autor.endereco = endereco.toModel()

        val uri = UriBuilder.of("autores/{id}/endereco").expand(mutableMapOf(Pair("id", autor.id)))
        return HttpResponse.created(uri)

    }
}
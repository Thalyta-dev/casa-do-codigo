package br.com.zup.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid
import kotlin.reflect.KFunction1

@Validated
@Controller("/autores")
class AutorController(
    val autorRespository: AutorRespository
) {

    @Post
    fun cadastra(@Body @Valid request: AutorRequest): HttpResponse<Any> {

        val toAutor = request.toAutor().let { autor ->
            autorRespository.save(autor)

        }

        val uri = UriBuilder.of("autores/{id}").expand(mutableMapOf(Pair("id", toAutor.id)))
        return  HttpResponse.created(uri)

    }

    @Get
    fun retornaAutores(): HttpResponse<List<DetalhesAutorResponse>> {

        val autores = autorRespository.findAll().map {autor -> DetalhesAutorResponse(autor)}

        return HttpResponse.ok(autores)
    }

}
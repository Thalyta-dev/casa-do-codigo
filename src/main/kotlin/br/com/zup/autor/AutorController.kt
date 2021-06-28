package br.com.zup.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class AutorController(
    val autorRespository: AutorRespository
) {

    @Post
    fun cadastra(@Body @Valid request: AutorRequest): HttpResponse<Any> {

        val toAutor = request.toAutor().let { autor -> autorRespository.save(autor) }

        val uri = UriBuilder.of("autores/{id}").expand(mutableMapOf(Pair("id", toAutor.id)))
        return HttpResponse.created(uri)

    }

    @Get
    fun retornaAutores(@QueryValue(defaultValue = "") email: String): HttpResponse<Any> {

        if (email.isBlank()) {
            val autores = autorRespository.findAll().map { autor -> DetalhesAutorResponse(autor) }

            return HttpResponse.ok(autores)
        }

        val autorEmail = autorRespository.findByEmail(email)

        if (autorEmail.isEmpty) return HttpResponse.notFound()

        return HttpResponse.ok(autorEmail)


    }
        @Put("/{id}")
        fun atualiza(@PathVariable id: Long, descricao: String): HttpResponse<Any> {

            val possivelAutor = autorRespository.findById(id)

            if (possivelAutor.isEmpty) return HttpResponse.notFound()

            val autor = possivelAutor.get()

            autor.descricao = descricao

            autorRespository.update(autor)

            return HttpResponse.ok(DetalhesAutorResponse(autor))

        }

        @Delete("/{id}")
        fun deleta(@PathVariable id: Long): HttpResponse<Any> {

            val possivelAutor = autorRespository.findById(id)

            if (possivelAutor.isEmpty) return HttpResponse.notFound()

            autorRespository.deleteById(id)

            return HttpResponse.ok()

        }


    }
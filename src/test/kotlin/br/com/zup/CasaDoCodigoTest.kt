package br.com.zup
import br.com.zup.autor.Autor
import br.com.zup.autor.AutorRespository
import br.com.zup.autor.DetalhesAutorResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import javax.inject.Inject

@MicronautTest
class CasaDoCodigoTest {



    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @field:Inject
    lateinit var autorRespository: AutorRespository

    lateinit var autor : Autor



    @BeforeEach
    internal  fun setup(){

        autor = Autor("Thalyta princesa","thalytalindademais@gmail.com",
            "A thalyta é o ser humano mais inteigente e lindo" )
        autorRespository.save(autor)
    }

    @AfterEach
    internal  fun tearDown(){

        autorRespository.deleteAll()

    }



    @Test
    fun deveRetornarDetalhesAutor() {



        val response = client.toBlocking()
            .exchange("/autores?email=thalytalindademais@gmail.com",
            DetalhesAutorResponse::class.java)

        assertEquals(HttpStatus.OK, response.status )
        assertNotNull(response.body())
    }

}

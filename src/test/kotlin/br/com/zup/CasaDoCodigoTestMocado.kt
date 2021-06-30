package br.com.zup;

import br.com.zup.autor.Autor
import br.com.zup.autor.AutorRequest
import br.com.zup.autor.AutorRespository
import br.com.zup.endereco.CepClient
import br.com.zup.endereco.EnderecoClient
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject
import javax.transaction.Transactional

@MicronautTest
class CasaDoCodigoTestMocado {


    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @field:Inject
    lateinit var autorRespository: AutorRespository

    lateinit var autorRequest: AutorRequest

    lateinit var autor: Autor

    lateinit var autorSalvo: Autor


    @field:Inject
    lateinit var cepClient: CepClient

    val cepRequerido = "91760000"


    @BeforeEach
    internal fun setup() {

        autorRequest = AutorRequest(
            "Thalyta princesa", "thalytalindademais@gmail.com",
            "A thalyta é o ser humano mais inteigente e lindo"
        )


    }

    @AfterEach
    internal fun saida() {

        autorRequest = AutorRequest(
            "Thalyta princesa", "thalytalindademais@gmail.com",
            "A thalyta é o ser humano mais inteigente e lindo"
        )


    }



    @Test
    @Transactional
    fun `deve mockar cepClient`() {

        autor = autorRequest.toAutor()

        autorSalvo = autorRespository.save(autor)


        var end = EnderecoClient(
            "travessa", "kz", "38970000",
            "camposaltin", "565656", "ggg", "36", "42542", "mg"
        )


        Mockito.`when`(cepClient.recebeCep(cepRequerido)).thenReturn(end)

        val cep = object {
            val cep = cepRequerido
        }
        val request = HttpRequest.POST("/autores/5/endereco", cep)

        val response = client.toBlocking().exchange(request, Any::class.java)

        assertEquals(HttpStatus.CREATED, response.status)
        assertTrue(response.headers.contains("Location"))


    }

    @MockBean(CepClient::class)
    fun `enderecoMock`(): CepClient {

        return Mockito.mock(CepClient::class.java)

    }
}
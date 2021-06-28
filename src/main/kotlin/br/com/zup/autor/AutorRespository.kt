package br.com.zup.autor

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface AutorRespository: CrudRepository<Autor,Long> {

    fun findByEmail(email: String): Optional<Autor>
}
package br.com.zup.autor

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface AutorRespository: CrudRepository<Autor,Long> {
}
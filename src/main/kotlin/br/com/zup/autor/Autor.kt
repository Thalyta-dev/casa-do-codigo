package br.com.zup.autor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Autor(

    @field: NotBlank val nome: String,
    @field: NotBlank @field:Email val email: String,
    @field: NotBlank @field:Size(max = 400) var descricao: String,
    @field: Id  @field: GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0

) {
}
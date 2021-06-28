package br.com.zup.autor

import br.com.zup.endereco.Endereco
import javax.persistence.*
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

    @ManyToOne(cascade = [CascadeType.ALL])
    var endereco = Endereco()
}
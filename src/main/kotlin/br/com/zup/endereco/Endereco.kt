package br.com.zup.endereco

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Endereco(

    @field: Id @field: GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val logradouro: String = "",
    val localidade : String= "",
    val uf :String= "",
    val cep :String= ""
) {
}
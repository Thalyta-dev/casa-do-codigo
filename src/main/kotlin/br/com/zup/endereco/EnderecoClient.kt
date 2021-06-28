package br.com.zup.endereco

data class EnderecoClient(
    val logradouro: String,
    val localidade : String,
    val cep : String,
    val bairro : String,
    val ibge : String,
    val gia : String,
    val ddd : String,
    val siafi : String,
    val uf : String) {

}

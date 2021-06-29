package br.com.zup.validacao

import br.com.zup.autor.Autor
import br.com.zup.autor.AutorRespository
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import java.util.*
import javax.inject.Singleton

@Singleton
class UniqueEmailValidator(val manager: AutorRespository) : ConstraintValidator<UniqueEmail, Any> {



    override fun isValid(
        value: Any?,
        annotationMetadata: AnnotationValue<UniqueEmail>,
        context: ConstraintValidatorContext
    ): Boolean {

        println(context.toString())
        var query: Optional<Autor> = manager.findByEmail(value.toString())



        return query.isEmpty    }

}
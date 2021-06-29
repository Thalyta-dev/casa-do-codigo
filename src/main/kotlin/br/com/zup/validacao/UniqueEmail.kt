package br.com.zup.validacao

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [UniqueEmailValidator::class])
annotation class UniqueEmail(

    val message: String = "email repetido",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [])

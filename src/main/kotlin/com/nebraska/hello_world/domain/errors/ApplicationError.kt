package com.nebraska.hello_world.domain.errors

open class ApplicationError(
    override val message: String,
    override val cause: Throwable? = null
) : RuntimeException() {
    open fun toMap(): Map<String, Any>? {
        return mapOf("error" to message)
    }
}

class ProductNotFound(id: Long) : ApplicationError("No product with id $id was found")
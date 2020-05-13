package com.brasstacks.angular_dart_generator.generator

import com.google.common.io.CharStreams
import com.fleshgrinder.extensions.kotlin.*
import org.apache.commons.lang.text.StrSubstitutor
import java.io.InputStreamReader
import java.lang.RuntimeException

abstract class Generator(private val componentName: String,
                         templateName: String) {

    private val TEMPLATE_COMPONENT_PASCAL_CASE = "component_pascal_case"
    private val TEMPLATE_COMPONENT_SNAKE_CASE = "component_snake_case"
    private val TEMPLATE_COMPONENT_SELECTOR_CASE = "component_selector_case"

    private val templateString: String
    private val templateValues: MutableMap<String, String>

    init {
        templateValues = mutableMapOf(
            TEMPLATE_COMPONENT_PASCAL_CASE to pascalCase(),
            TEMPLATE_COMPONENT_SNAKE_CASE to snakeCase(),
            TEMPLATE_COMPONENT_SELECTOR_CASE  to selectorCase()
        )
        try {
            val resource = "/templates/$templateName.template"
            val resourceAsStream = Generator::class.java.getResourceAsStream(resource)
            templateString = CharStreams.toString(InputStreamReader(resourceAsStream, Charsets.UTF_8))
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    abstract fun fileName(): String

    fun generate(): String {
        val substitutor = StrSubstitutor(templateValues)
        return substitutor.replace(templateString)
    }

    fun pascalCase(): String = componentName.toUpperCamelCase()

    fun snakeCase() = componentName.toLowerSnakeCase()

    fun selectorCase() = componentName.toLowerDashCase()
}
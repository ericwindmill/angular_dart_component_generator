package com.brasstacks.angular_dart_generator.generator

import com.brasstacks.angular_dart_generator.generator.components.ComponentDartGenerator
import com.brasstacks.angular_dart_generator.generator.components.ComponentHtmlGenerator
import com.brasstacks.angular_dart_generator.generator.components.ComponentScssGenerator

object ComponentGeneratorFactory {
    fun getBlocGenerators(componentName: String): List<Generator> {
        val dartFile = ComponentDartGenerator(componentName)
        val htmlFile = ComponentHtmlGenerator(componentName)
        val scssFile = ComponentScssGenerator(componentName)
        return listOf(dartFile, htmlFile, scssFile)
    }
}
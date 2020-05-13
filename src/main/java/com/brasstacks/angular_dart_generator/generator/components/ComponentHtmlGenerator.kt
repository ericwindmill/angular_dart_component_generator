package com.brasstacks.angular_dart_generator.generator.components

import com.brasstacks.angular_dart_generator.generator.Generator

class ComponentHtmlGenerator(
    componentName: String
) : Generator(componentName, templateName = "component.html") {

    override fun fileName() = "${snakeCase()}_component.html"
}
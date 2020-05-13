package com.brasstacks.angular_dart_generator.generator.components

import com.brasstacks.angular_dart_generator.generator.Generator

class ComponentScssGenerator(
    componentName: String
) : Generator(componentName, templateName = "component.scss") {

    override fun fileName() = "${snakeCase()}_component.scss"
}
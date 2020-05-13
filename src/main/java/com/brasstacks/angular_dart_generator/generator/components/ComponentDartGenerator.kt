package com.brasstacks.angular_dart_generator.generator.components

import com.brasstacks.angular_dart_generator.generator.Generator

class ComponentDartGenerator(
    componentName: String
) : Generator(componentName, templateName = "component.dart") {

    override fun fileName() = "${snakeCase()}_component.dart"
}
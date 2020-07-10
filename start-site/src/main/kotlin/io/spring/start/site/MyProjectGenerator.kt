package io.spring.start.site

import io.spring.initializr.generator.project.ProjectGenerationConfiguration
import io.spring.initializr.generator.project.ProjectGenerationContext
import io.spring.initializr.generator.project.ProjectGenerator
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import java.util.function.Consumer


@Component
@ProjectGenerationConfiguration
class MyProjectGenerator {


  fun createProjectGenerator(appContext: ApplicationContext?): ProjectGenerator? {
    return ProjectGenerator(Consumer { context: ProjectGenerationContext ->
      context.parent = appContext
      context.registerBean(MyContributer::class.java, { MyContributer() })
    })
  }


}
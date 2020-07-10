package io.spring.start.site

import io.spring.initializr.generator.project.ProjectGenerationConfiguration
import io.spring.initializr.generator.project.contributor.ProjectContributor
import org.springframework.stereotype.Component
import java.io.IOException
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Path

@Component
@ProjectGenerationConfiguration
class MyContributer : ProjectContributor {
  @Throws(IOException::class)
  override fun contribute(projectRoot: Path) {
    val file: Path = Files.createFile(projectRoot.resolve("hello.txt"))
    PrintWriter(Files.newBufferedWriter(file)).use { writer -> writer.println("Test") }
  }
}
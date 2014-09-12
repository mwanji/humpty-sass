package co.mewf.humpty.sass;

import java.nio.file.Paths;

import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;

import co.mewf.humpty.config.Configuration;
import co.mewf.humpty.config.PreProcessorContext;
import co.mewf.humpty.spi.processors.SourceProcessor;

import com.vaadin.sass.internal.ScssStylesheet;

/**
 * Compiles Sass files using <a href="https://github.com/vaadin/sass-compiler">Vaadin's Sass compiler</a>, a Java-based compiler.
 * 
 * It accepts files with an ".scss" extension.
 * 
 * Configuration name: sass
 * 
 * Options:
 * rootDir: The root of where to look for assets. Relative to project root. Defaults to src/main/resources.
 */
public class SassSourceProcessor implements SourceProcessor {
  
  private String rootDir;

  @Override
  public String getName() {
    return "sass";
  }

  @Inject
  public void configure(Configuration.Options options) {
    this.rootDir = options.get("rootDir", "src/main/resources");
  }
  
  @Override
  public boolean accepts(String assetName) {
    return assetName.endsWith(".scss");
  }

  @Override
  public CompilationResult compile(CompilationResult compilationResult, PreProcessorContext context) {
    try {
      String path = Paths.get(rootDir).resolve(compilationResult.getAssetName()).toFile().getAbsoluteFile().getAbsolutePath();
      ScssStylesheet stylesheet = ScssStylesheet.get(path);
      stylesheet.compile();
      String css = stylesheet.printState();
      
      return new CompilationResult(FilenameUtils.getBaseName(compilationResult.getAssetName()) + ".css", css);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

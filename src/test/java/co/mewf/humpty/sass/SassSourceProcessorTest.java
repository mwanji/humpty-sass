package co.mewf.humpty.sass;

import static java.nio.file.Files.readAllBytes;
import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.Test;

import co.mewf.humpty.Pipeline;
import co.mewf.humpty.config.HumptyBootstrap;

public class SassSourceProcessorTest {

  @Test
  public void should_compile_sass() throws Exception {
    Pipeline pipeline = new HumptyBootstrap().createPipeline();
    
    String result = pipeline.process("basic.css");
    
    String expected = new String(readAllBytes(Paths.get("src", "test", "resources", "META-INF", "resources", "webjars", "humpty-sass", "1.0.0", "test_basic.css")));
    
    assertEquals(expected, result);
  }
  
  @Test
  public void should_import() throws Exception {
    Pipeline pipeline = new HumptyBootstrap().createPipeline();
    
    String result = pipeline.process("import.css");
    
    System.out.println(result);
  }
}

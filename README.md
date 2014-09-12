# humpty-sass

humpty-sass wraps [Vaadin's Java-based Sass compiler](https://github.com/vaadin/sass-compiler) and integrates it into the [humpty](https://github.com/mwanji/humpty) asset pipeline.

## Configuration

Add humpty-sass to your dependencies:

````xml
<dependency>
  <groupId>co.mewf.humpty</groupId>
  <artifactId>humpty-sass</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
````

In your humpty.toml file, you have the following configuration options:

````toml
[options.sass]
  rootDir = "path/to/sass/root" # The root folder where Sass files are located. Defaults to "src/main/resources"
````

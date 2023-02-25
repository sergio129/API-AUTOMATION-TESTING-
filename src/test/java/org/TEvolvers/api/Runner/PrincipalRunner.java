package org.TEvolvers.api.Runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "org.TEvolvers.api.stepDefinitions",
        features = "src/test/resources/features/",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@ListarReservas",
        monochrome = true

)
public class PrincipalRunner {
}

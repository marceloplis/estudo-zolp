package br.com.zolp.estudozolp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe ressponsável pela configuração do Swagger.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public final void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private static final Contact DEFAULT_CONTACT = new Contact(
        "xxxxxxxxx",                      // Nome
        "http://api.XXXXXXXXX.com.br",  // URL
        "gXXXXXXX@XXXX.XXX");    // Email

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
        "Ms-Estudo-Zolp",                        // Titulo
        "Aplicação responsável por efetuar o tratamento" // Descrição
        + "do processo de xxxxxxxxxxxxxxxxx.",
        "1.0",                                           // Versão
        "Termos do serviço",                             // Termos
        DEFAULT_CONTACT,                                 // Contato
        "Apache 2.0",                                    // Licenca
        "http://www.apache.org/licenses/LICENSE-2.0",    // Url Licenca
        Collections.emptyList()
    );

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
        Arrays.asList("application/json", "application/xml"));

    /**
     * Efetua a configuração das informações da aplicação no swagger.
     *
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

//    /**
//     * Configuracao para desabilitar o botao "try-it-out" do Swagger em producao.
//     * Em desenvolvimento, manter comentado.
//     * Em producao, retirar comentarios.
//     *
//     * @return
//     */
//    import springfox.documentation.swagger.web.UiConfiguration;
//    import springfox.documentation.swagger.web.UiConfigurationBuilder;
//    @Bean
//    UiConfiguration uiConfig() {
//      final String[] noSupportedMethods = {};
//      return UiConfigurationBuilder.builder()
//                                   .supportedSubmitMethods(noSupportedMethods)
//                                   .build();
//    }

}

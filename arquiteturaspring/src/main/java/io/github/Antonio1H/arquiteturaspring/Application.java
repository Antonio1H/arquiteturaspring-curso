package io.github.Antonio1H.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		// Forma simplificada de iniciar uma aplicação Spring Boot.
		// Estamos usando o SpringApplicationBuilder abaixo para
		// configurar a inicialização antes de executar a aplicação.
		// SpringApplication.run(Application.class, args);

		// Cria um configurador para a inicialização do Spring Boot.
		// Application.class informa qual é a classe principal
		// que o Spring deve utilizar para iniciar a aplicação.
		SpringApplicationBuilder builder =
				new SpringApplicationBuilder(Application.class);

		// Desativa o banner do Spring Boot que aparece no terminal
		// durante a inicialização.
		// Isso altera apenas a apresentação no console, não o funcionamento.
		builder.bannerMode(Banner.Mode.OFF);

		// Seleciona o perfil "producao".
		// O Spring usará as configurações associadas a esse perfil,
		// como as que podem estar em application-producao.properties.
		builder.profiles("producao");

		// Inicia a aplicação Spring Boot com as configurações definidas.
		// Nesse processo, o Spring prepara o contexto e gerencia os Beans.
		builder.run(args);

		// Obtém o contexto da aplicação iniciada.
		// O contexto gerencia os objetos (Beans) do Spring
		// e permite acessar recursos e configurações da aplicação.
		ConfigurableApplicationContext applicationContext =
				builder.context();

		// Obtém o ambiente de configuração do contexto.
		// Ele permite consultar propriedades, como o nome da aplicação,
		// e verificar informações sobre os perfis ativos.
		ConfigurableEnvironment environment =
				applicationContext.getEnvironment();

		// Consulta a propriedade "spring.application.name".
		// O valor normalmente é definido em application.properties
		// ou em outro arquivo/fonte de configuração.
		// Se a propriedade não existir, o resultado será null.
		String applicationName = environment.getProperty("spring.application.name");

		// Exibe no terminal o nome encontrado nas configurações.
		System.out.println("Application Name: " + applicationName);
	}
}



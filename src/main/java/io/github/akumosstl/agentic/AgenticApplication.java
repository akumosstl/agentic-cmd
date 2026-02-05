package io.github.akumosstl.agentic;

import io.github.akumosstl.agentic.work.FolderCreator;
import io.github.akumosstl.agentic.work.Orchestrator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AgenticApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(AgenticApplication.class, args);

	}

	@Component
	public static class MyAppRunner implements CommandLineRunner {

		private final ConfigurableApplicationContext context;

		public MyAppRunner(ConfigurableApplicationContext context) {
			this.context = context;
		}

		@Override
		public void run(String... args) throws Exception {
			FolderCreator.createFolderInUserHome(".agentic");
			Orchestrator.main(null);
			context.close();
		}
	}

}

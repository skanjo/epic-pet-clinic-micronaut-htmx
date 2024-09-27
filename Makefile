# Variables
GRADLE=./gradlew
NPM=npm
ENV?=dev

.PHONY: clean setup build run watch

# Clean the project removing backend anf frontend files
clean:
	$(GRADLE) clean
	rm -rf node_modules

# Setup project: clean, build, install npm packages, build tailwind
setup: clean
	$(NPM) install
	$(NPM) run tailwind:build:$(ENV)
	$(GRADLE) build -Dmicronaut.environments=$(ENV)

# Build the project for development
build:
	$(NPM) run tailwind:build:$(ENV)
	$(GRADLE) build -Dmicronaut.environments=$(ENV)

# Run the server and hot reload. Use this with watch in separate session.
run:
	$(GRADLE) run -Dmicronaut.environments=$(ENV) --continuous

# Build Tailwind and watch for changes. Use this with run in separate session.
watch:
	$(NPM) run tailwind:watch

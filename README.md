# testFireDemoSerenity

### Framework used
This project is test automation of user management application hosted at "http://85.93.17.135:9000" that uses serenity automation framework using Screen Play Design Pattern

This framework also covers a scenario to hit a REST endpoint using serenity's integration with rest assured.

### Running test
```sh
$ mvn clean verify
```

### Running in headless mode
This will enable us to run automation in CI tools like Jenkins , GO .

Install Phantomjs
```sh
$ brew install phantomjs
```

Run following command
```sh
$ mvn clean -Dwebdriver.driver=phantomjs verify
```

### Reports
After running the test serenity reports will be generated at following location
```sh
<ProjectDir>/target/site/serenity/index.html
```
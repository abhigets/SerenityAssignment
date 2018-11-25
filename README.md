# testFireDemoSerenity

### Framework used
This project is test automation of @DefaultUrl("https://serene-mountain-14043.herokuapp.com") using serenity automation framework using Screen Play Design Pattern


### Running test
```sh
$ geckodriver &
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
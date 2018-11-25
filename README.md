# Assignment 1
(Using BDD approach, build a small automation framework)

### Scenarios implemented
1. Search for a valid post code (should_be_able_to_search_a_postcode_and_see_weather_details)
2. Valid all the manditory field (should_be_able_to_search_a_postcode_and_see_weather_details)
3. Valid all the optional field (should_be_able_to_search_a_postcode_and_see_weather_details)
4. Search Non existing post code (should_be_able_to_see_error_message_for_invalid_postcode)
5. Search invalid post code (should_be_able_to_see_error_message_for_non_existing_postcode)

### Framework used
This project is test automation of Weather Cherker app ("https://serene-mountain-14043.herokuapp.com") using serenity automation framework with Screen Play Design Pattern


### Running test
Clone the repo 
Make sure you have maven
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
# Assignment 2
Q : Suppose you want to run some of these test in a development pipeline thats independent from the backend pipeline. Explain how you could approach this:
  -What techniques,framework or tools you might thing using
  -how you would go abount integrating this framework with a CI pipeline.



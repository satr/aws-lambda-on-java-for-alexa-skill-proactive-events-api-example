# AWS Lambda function on Java for Amazon Alexa Proactive Events API example  
This code extends [AWS Lambda function on Java with Gradle for a simple Alexa Skill example](https://github.com/satr/aws-lambda-on-java-with-gradle-for-simple-alexa-skill-example)

"AWS Lambda function on Java with Gradle for a simple Alexa Skill example": [article](https://medium.com/voice-tech-podcast/create-simple-amazon-alexa-skill-with-backend-on-java-fcdbac05ed14), [video](https://www.youtube.com/watch?v=5rHIHUjuNRk) 

"Get started with Amazon Alexa Skills Proactive Events API": [article](https://medium.com/swlh/get-started-with-amazon-alexa-skills-proactive-events-api-5b082bcb282c), [video](https://www.youtube.com/watch?v=6Ul_ry2hq2w)

[Java ASK Proactive API kit](https://github.com/satr/java-ask-proactive-api-kit)

Dependencies and jar-task in `gradle.build`

```
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile group: 'com.amazon.alexa', name: 'ask-sdk', version:'2.17.2'
    compile group: 'com.amazonaws', name: 'aws-lambda-java-log4j2', version:'1.1.0'
}

jar {
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}
```

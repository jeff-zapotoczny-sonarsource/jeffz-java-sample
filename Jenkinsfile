pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withSonarQubeEnv('SQServer') {
          withMaven('M3') {
            script {
              if (env.CHANGE_ID) {
                // build like a pull request 
                sh "mvn -Dmaven.test.failure.ignore clean verify sonar:sonar -Dsonar.pullrequest.branch=${CHANGE_BRANCH} -Dsonar.pullrequest.key=${CHANGE_ID} -Dsonar.pullrequest.base=master"
              } else {
                sh "mvn -Dmaven.test.failure.ignore clean verify sonar:sonar"
              }
            }
          }
        }
      }
    }
    stage('Test') {
      steps {
        junit '**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.jar'
      }
    }
  }
}

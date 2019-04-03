pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withSonarQubeEnv('SQServer') {
          withMaven(maven: 'M3') {
            script {
              if (env.CHANGE_ID) {
                // build like a pull request 
                sh "mvn -Dmaven.test.failure.ignore clean verify sonar:sonar -Dsonar.pullrequest.branch=${CHANGE_BRANCH} -Dsonar.pullrequest.key=${CHANGE_ID} -Dsonar.pullrequest.base=master"
              } else {
                // build like a main branch
                sh "mvn -Dmaven.test.failure.ignore clean verify sonar:sonar -Dsonar.branch.name=${BRANCH_NAME}"
              }
            }
          }
        }
      }
    }
  }
}

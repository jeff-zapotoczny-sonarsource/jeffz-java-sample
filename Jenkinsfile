pipeline {
  agent any
  stages {
    stage('SCM') {
      steps {
        // fetch master from origin so sonar scanner comparison works
        sh "git fetch --no-tags ${GIT_URL} +refs/heads/master:refs/remotes/origin/master"
      }
    }
    stage('Build') {
      steps {
        withMaven(maven: 'M3') {
          script {
            sh "mvn -Dmaven.test.failure.ignore clean verify"
	  }
        }
      }
    }
    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SQServer') {
          withMaven(maven: 'M3') {
            script {
	      // all analysis now automatically parameterized
              sh "mvn sonar:sonar"
            }
          }
        }
      }
    }
    stage('Quality Gate') {
      steps {
        timeout(time: 1, unit: 'HOURS') {
          waitForQualityGate abortPipeline: true
        }
      }
    }
  }
}

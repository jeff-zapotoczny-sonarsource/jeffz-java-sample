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
              if (env.CHANGE_ID) {
                // analyze as pull request 
                sh "mvn sonar:sonar -Dsonar.pullrequest.branch=${CHANGE_BRANCH} -Dsonar.pullrequest.key=${CHANGE_ID} -Dsonar.pullrequest.base=master"
              } else if (env.BRANCH_NAME=="master") {
                sh "mvn sonar:sonar"
	      } else {
                // analyze as a branch
                //sh "mvn sonar:sonar -Dsonar.branch.name=${BRANCH_NAME}"
              }
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

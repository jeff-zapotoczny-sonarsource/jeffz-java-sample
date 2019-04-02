node {
   def mvnHome
   stage('Preparation') { // for display purposes
   	  // print environment
      echo sh(returnStdout: true, script: 'env')
      // Get code from GitHub repository
      git branch: '${CHANGE_BRANCH}', url:'https://github.com/jeff-zapotoczny-sonarsource/jeffz-java-sample.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
    withSonarQubeEnv('SQServer') {
      //if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify sonar:sonar -Dsonar.pullrequest.branch=${CHANGE_BRANCH} -Dsonar.pullrequest.key=${CHANGE_ID} -Dsonar.pullrequest.base=master"
      //} else {
         //bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      //}
    }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}

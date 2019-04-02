node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get code from GitHub repository
      git 'https://github.com/jeff-zapotoczny-sonarsource/jeffz-java-sample.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
    withSonarQubeEnv('SQServer') {
      //if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify sonar:sonar"
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

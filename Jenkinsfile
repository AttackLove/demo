pipeline {
agent any
environment {
        EMAIL_RECIPIENTS = 'mahmoud.romeh@test.com'
    }
stages {
	stage('Build with unit testing'){
		steps {
			script {
				echo 'Pulling...' + env.BRANCH_NAME
                def mvnHome = tool 'Maven 3.3.9'
				if (isUnix()) {
					def targetVersion = v1.0-test
					print 'target build version...'
					print targetVersion
					sh "'${mvnHome}/bin/mvn' -Dintegration-tests.skip=true -Dbuild.number=${targetVersion} clean package"
					def pom = readMavenPom file: 'pom.xml'
					// get the current development version
					developmentArtifactVersion = "${pom.version}-${targetVersion}"
					print pom.version
					// execute the unit testing and collect the reports
					junit '**//*target/surefire-reports/TEST-*.xml'
					archive 'target*//*.jar'
				} else {
					bat(/"${mvnHome}\bin\mvn" -Dintegration-tests.skip=true clean package/)
					def pom = readMavenPom file: 'pom.xml'
					print pom.version
					junit '**//*target/surefire-reports/TEST-*.xml'
					archive 'target*//*.jar'
				}
			}
		}
	}
}

}
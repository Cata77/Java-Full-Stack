pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                dir('./backend') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Unit Test') {
            steps {
                dir('./backend') {
                    bat 'mvn test'
                }
            }
        }

        stage('Integration Test') {
            steps {
                dir('./backend') {
                    bat 'mvn verify'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'backend/target/*.jar'
        }

        success {
            echo 'Build and tests passed successfully!'
        }

        failure {
            echo 'Build or tests failed!'
        }
    }
}

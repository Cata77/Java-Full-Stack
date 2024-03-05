pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                dir('backend') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Unit Test') {
            steps {
                dir('backend') {
                    sh 'mvn test'
                }
            }
        }

        stage('Integration Test') {
            steps {
                dir('backend') {
                    sh 'mvn test'
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

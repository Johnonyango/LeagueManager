
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 
                sh './mvnrw clean compile'
            }
        }
    }
}


pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/Johnonyango/LeagueManager.git
                sh './mvnrw clean compile'
            }
        }
    }
}

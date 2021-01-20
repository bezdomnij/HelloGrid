pipeline {
    agent any
    environment {
        BROWSER = "chrome"
    }
    stages {
        stage ('Build'){

            steps {
                sh 'mvn --version'
                sh 'echo $BROWSER'
                }
        }
    }
}
pipeline {
    agent any
    environment {
        BROWSERUSED = "chrome"
        SEL_USER = "selenium"
    }
    stages {
        stage ('Build'){

            steps {
                sh 'mvn --version'
                sh 'echo $BROWSERUSED'
                sh 'echo $SEL_USER'
                }
        }
    }
}
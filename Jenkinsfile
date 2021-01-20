pipeline {
    agent any
    environment {
        BROWSER = "chrome"
        SEL_USER = "selenium"
    }
    stages {
        stage ('Build'){

            steps {
                sh 'mvn --version'
                sh 'echo $BROWSER'
                echo $SEL_USER
                }
        }
    }
}
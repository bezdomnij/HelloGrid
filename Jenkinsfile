pipeline {
    agent any
    environment {
        BROWSER_USED = "chrome"
        SEL_USER = "selenium"
    }
    stages {
        stage ('Build'){
            steps {
                sh 'mvn --version'
                sh 'mvn clean'
                sh 'echo $BROWSER_USED'
                sh 'echo $SEL_USER'
                sh 'printenv | sort'
                }
        }
        stage {
            steps {
                sh 'mvn test'
            }
        }
    }
}
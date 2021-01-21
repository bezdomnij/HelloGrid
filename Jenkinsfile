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
        stage ('run with firefox'){
            steps {
//                 sh 'export BROWSER=firefox'
                sh 'echo $BROWSER'
                sh 'mvn -DBROWSER={BROWSER=firefox} test'
            }
        }
        stage ('run with chrome'){
                    steps {
        //                 sh 'export BROWSER=firefox'
                        sh 'echo $BROWSER'
                        sh 'mvn -DBROWSER={BROWSER=chrome} test'
                    }
                }
    }
    post {
        always {
            echo 'Cleanup phase'
            cleanWs()
            }
        }
}
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
            when {
                expression { params.BROWSER == 'both' || params.BROWSER == 'firefox'}
                }
            steps {
//                 sh 'export BROWSER=firefox'
                sh 'echo $BROWSER'
                sh 'mvn -DBROWSER=${params.firefox} test'
            }
        }
        stage ('run with chrome'){
                    when {
                        expression { params.BROWSER == 'both' || params.BROWSER == 'chrome'}
                        }
                    steps {
        //                 sh 'export BROWSER=firefox'
                        sh 'echo $BROWSER'
                        sh 'mvn -DBROWSER=${params.chrome} test'
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
pipeline {
    agent any
    parameters {
        string(name: 'browserToRun', defaultValue: 'both', description: 'Browsers to run: Both, Chrome, Firefox')
        string(name: 'chrome', defaultValue: 'chrome', description: 'Chrome browser')
        string(name: 'firefox', defaultValue: 'firefox', description: 'Firefox browser')
        }
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
            script {
                    env.BROWSER = firefox
                            }
                sh 'echo run w/ firefox'
                sh 'echo $BROWSER'
                sh 'echo $BROWSER'
//                 sh 'mvn -DBROWSER=${parameters.firefox} test'
            }
        }
        stage ('run with chrome'){
            when {
                expression { params.BROWSER == 'both' || params.BROWSER == 'chrome'}
                }
            steps {
                        script {
                                env.BROWSER = chrome
                                        }
            sh 'echo run w/ chrome'
//                 sh 'export BROWSER=firefox'
                sh 'echo $BROWSER'
                sh '$BROWSER=$chrome'
                sh 'echo $BROWSER'
//                         sh 'mvn test'
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
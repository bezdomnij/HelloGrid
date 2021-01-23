pipeline {
    agent any
    parameters {
        string(name: 'browserToRun', defaultValue: 'both', description: 'Browsers to run: Both, Chrome, Firefox')
        string(name: 'chrome', defaultValue: 'chrome', description: 'Chrome browser')
        string(name: 'firefox', defaultValue: 'firefox', description: 'Firefox browser')
        }
    environment {
        SEL_USER = "selenium"
        }
    stages {
        stage ('Build'){
            steps {
                script {withCredentials(usernamePassword([
                            credentialsId: 'githubcreds',
                            passwordVariable: 'pass',
                            usernameVariable: 'user')]
                }
                sh 'mvn --version'
                sh 'mvn clean'
                sh 'echo $user'
                sh 'printenv | sort'
                }
        }
        stage ('Parallel stage') {
            failFast true
            parallel {
                stage ('run with firefox'){
                    environment {
                        BROWSER = "firefox"
                    }
                    steps {
                        sh 'echo run w/ firefox'
                        sh 'echo $BROWSER'
                        sh 'mvn test'
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
                }
                stage ('run with chrome'){
                    environment {
                        BROWSER = "chrome"
                    }
                    steps {
                        sh 'echo run w/ chrome'
                        sh 'echo $BROWSER'
                        sh 'mvn test'
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
                }
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
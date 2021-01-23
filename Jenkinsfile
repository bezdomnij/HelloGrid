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
                script {withCredentials([usernamePassword(
                    credentialsId: 'jira2-admin',
                    passwordVariable: 'pass',
                    usernameVariable: 'user'),
                    usernamePassword(
                    credentialsId: 'jira-user6-credentials',
                    passwordVariable: 'sel_pass',
                    usernameVariable: 'username')]) {
                        echo 'Test WITH USER: '
                        echo $user
//                         sh "mvn test -DUSER=$user -DPASS=$pass -DSEL_PASS=$sel_pass"
                    }
                }
                }
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

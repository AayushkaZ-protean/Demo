pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps {
                git(
                    url: "https://github.com/AayushkaZ-protean/Demo/blob/main/Jenkinsfile",
                    branch: "main",
                    changelog: true,
                    poll: true,
                    gitTool: 'Default'
                )
            }
        }
stage("Create artifacts or make changes") {
            steps {
                sh "touch testfile"
                sh "git add testfile"
                sh "git commit -m 'Add testfile from Jenkins Pipeline'"
            }
        }
        stage("Push to Git Repository") {
            steps {
                withCredentials([gitUsernamePassword(credentialsId: 'aayushkaz-protean-github-token', gitToolName: 'Default')]) {
                    sh "git push -u origin main"
                }
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}

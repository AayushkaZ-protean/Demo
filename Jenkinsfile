pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps {
                dir("neptune") {
                    git(
                        url: "https://github.com/AayushkaZ-protean/Demo.git",
                        branch: "main",
                        changelog: true,
                        poll: true
                    )
                }
            }
        }
    }
}

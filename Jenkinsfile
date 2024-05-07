pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps  {
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

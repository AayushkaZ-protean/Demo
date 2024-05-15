pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps  {
                    git(
                        url: "",
                        branch: "main",
                        changelog: true,
                        poll: true
                    )
            }
        }
    }
}

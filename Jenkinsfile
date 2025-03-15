pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([$class: 'GitSCM',
                             branches: [[name: 'refs/heads/main']],
                             userRemoteConfigs: [[url: 'https://github.com/karan-handa-clg/Lab2_Question2_COMP367.git']]
                    ])
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}

pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDENTIALS = 'docker-hub-credentials'  // Jenkins credentials ID
        DOCKER_IMAGE = 'karanhandaclg/comp367-webapp:latest'
    }
    stages {
        stage('Checkout SCM') {
            steps {
                // Checkout source code from GitHub repository
                checkout scm: [
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/karan-handa-clg/Lab2_Question2_COMP367.git']]
                ]
            }
        }

        stage('Build Maven Project') {
            steps {
                // Build Maven project (package the application)
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image using the Dockerfile
                sh "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Login to Docker Hub') {
            steps {
                // Login to Docker Hub using credentials stored in Jenkins
                withCredentials([usernamePassword(credentialsId: DOCKER_HUB_CREDENTIALS, usernameVariable: 'DOCKER_HUB_USER', passwordVariable: 'DOCKER_HUB_PASS')]) {
                    sh "echo \$DOCKER_HUB_PASS | docker login -u \$DOCKER_HUB_USER --password-stdin"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Push the built Docker image to Docker Hub
                sh "docker push $DOCKER_IMAGE"
            }
        }
    }
}
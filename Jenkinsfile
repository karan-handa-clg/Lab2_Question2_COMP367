pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDENTIALS = 'docker-hub-credentials'  // Jenkins credentials ID
        DOCKER_IMAGE = 'karanhandaclg/comp367-webapp:latest'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/karan-handa-clg/Lab2_Question2_COMP367.git'
            }
        }
        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }
        stage('Login to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_HUB_USER', passwordVariable: 'DOCKER_HUB_PASS')]) {
                    sh 'echo $DOCKER_HUB_PASS | docker login -u $DOCKER_HUB_USER --password-stdin'
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }
    }
}

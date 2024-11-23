pipeline {
    agent any

    stages {
        stage('Ripple Test') {
            steps {
                
               sh 'mvn clean test'
            }
        }
    }
}

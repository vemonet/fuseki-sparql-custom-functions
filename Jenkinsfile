pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git 'https://github.com/vemonet/translator-sparql-service.git'
      }
    }
    stage('build') {
      steps {
        sh 'docker build -t translator-sparql-service .'
      }
    }
  }
}

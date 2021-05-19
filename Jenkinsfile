pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git 'https://github.com/vemonet/fuseki-sparql-custom-functions.git'
      }
    }
    stage('build') {
      steps {
        sh 'docker build -t fuseki-sparql-custom-functions .'
      }
    }
  }
}

def imageName = 'demo-sbnk'
def version = 'latest'
def registry = 'https://demoudemy01.jfrog.io/'

pipeline {

    agent any

    environment {
        PATH = "/opt/gradle-8.6/bin:$PATH"
    }

    stages {
        stage("Build") {
            steps {
                sh 'echo "------------------- Building the app -------------------"'
                sh 'gradle build -x test'
                sh 'echo "------------------- Building complete the app -------------------"'
            }
        }
        stage("Docker build") {
            steps {
                script {
                echo "------------------- Building the docker image -------------------"

                app = docker.build(imageName + ":" + version)
                echo "------------------- Building complete the docker image -------------------"
                }
            }
        }
                stage("Docker publish") {
                    steps {
                        script {
                            echo "------------------- Publishing the docker image -------------------"
                            docker.withRegistry(registry, 'artifact-cred') {
                                app.push()
                            }
                            echo "------------------- Publishing complete the docker image -------------------"
                        }
                    }
                }
        stage ("Deploy kubernetes"){
            steps {
                script {
                    echo "------------------- Executing kubernetes -------------------"
                    sh 'kubectl apply -f /home/cmisaico/Documents/Proyectos/tiyd-infrastructure/kubernetes/dev/deploy-appointment.yaml --namespace=namespace-tiyd-dev --context minikube'
                    echo "------------------- Ending kubernetes -------------------"
                }
            }
        }



    }
}
node{
    stage("Git checkout"){
        git credentialsId: 'git-user-pass', url: 'https://github.com/huyto000/DemoJenkins.git'
        sh "echo $PWD"
        echo "Checkout successfully"
    }
    stage("Mvn package"){
        def mvnHome = tool name: 'Maven 3.6.3', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh label: '', script: "${mvnCMD} clean package"
        sh "echo $PWD"
        echo "Mvn clean successfully" 
    }
    stage("Build docker image"){
        sh label: '', script: 'docker build -t huyto000/demojenkins:latest .'
        sh "echo $PWD"
        echo "Build image successfully"
    }
    stage("Push to dockerhub"){
        withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
            sh label: '', script: 'docker login -u huyto000 -p ${dockerHubPwd}'
        }
        sh label: '', script: 'docker push huyto000/demojenkins:latest'
        sh "echo $PWD"
        echo "Push image successfully"
    }
    stage("Run container on server"){
        def dockerRemove = 'sudo docker rm -f my-app'
        def dockerRun = 'sudo docker run -d --name my-app -p 8090:8090 huyto000/demojenkins:latest'
        def dockerComposePull = 'sudo docker-compose pull'
        def dockerComposeUp = 'sudo docker-compose up -d'
        sshagent(['dev-server']) {
           sh "ssh -tt -o StrictHostKeyChecking=no huynv@192.168.20.216 ${dockerComposePull}"
        }
        sshagent(['dev-server']) {
           sh "ssh -tt -o StrictHostKeyChecking=no huynv@192.168.20.216 ${dockerComposeUp}"
        }
        echo "Deploy successfully"
    }
}
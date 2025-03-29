def call(String credID, String imageName){
    withCredentials([usernamePassword(
        credentialsId:"${credID}",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]){
                    
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker image tag "${imageName}" ${env.dockerHubUser}/${imageName}"
        sh "docker push ${env.dockerHubUser}/${imageName}"
        }
}
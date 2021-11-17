def VERSION = "v0"
def GITREPO = "git@github.com:zqrzxwkr-group/backend.git"
pipeline{  
    agent { label 'master' }
    tools { 
        jdk 'jdk11'
        maven 'maven3.6.3' 
    }
    stages{
        stage("代码克隆"){
            steps{
                sh "cd /var/lib/jenkins/workspace/backend-pipeline && rm -rf ./*"
                git branch: 'main', credentialsId: '1', url: "${GITREPO}"
                echo "代码克隆完成"
            }
        }
        
        stage("代码构建打包"){
            steps{
                //sh "cd /var/lib/jenkins/workspace/backend-pipeline/backend && mvn clean package"
                echo "代码构建打包完成"
            }
        }
	
        stage("制作docker镜像"){
            steps{
                //sh "cd /var/lib/jenkins/workspace/bookmanage-backend-pipeline/bookmanager && docker build -t 192.168.43.116:8081/bookmanage/bookmanage-backend:${VERSION} ."
                echo "制作docker镜像完成"
            }
        }
        
        stage("上传镜像"){
            steps{
                //sh "docker login 192.168.43.116:8081 -u jiqirui -p Harbor12345"
                //sh "docker push 192.168.43.116:8081/bookmanage/bookmanage-backend:${VERSION}"
                echo "上传镜像完成"
            }
        }
		
        stage("更新服务"){
            steps{
                //sh 'ssh root@192.168.43.250 "cd /root && rm -f bookmanage-backend.yaml"'
                //sh "cd /var/lib/jenkins/workspace/bookmanage-backend-pipeline && scp bookmanage-backend.yaml root@192.168.43.250:/root"
                //sh 'ssh root@192.168.43.250 "kubectl apply -f bookmanage-backend.yaml"'
                echo "更新服务"
            }
        }
    }
}

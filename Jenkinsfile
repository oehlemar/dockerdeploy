pipeline {
    agent any 
    
    environment {
        GIT_CREDENTIALS_ID = 'CI_devops'  // The ID for your credentials in Jenkins
        GIT_BRANCH = 'main'                      // Branch to push to
    }

    stages {
        stage('Checkout') { 
            steps {
                sh 'echo checkout'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/oehlemar/CI_devops']])
            }
        }

        stage('Build NPM (FRONTEND') {
            steps{
                dir('frontend'){
                    nodejs('NodeJS 20.10.0') {
                        sh 'npm install'
                        sh 'npm run build'
                    }
                }
            }
        }
        stage('Build with Gradle and Test (BACKEND)') {
            steps {
                dir('backend') {
                    sh 'chmod +x gradlew'
                    sh './gradlew test' // Runs the Gradle build script
                }
            }
        }
        /*stage('Test') { 
            steps {
                sh 'echo test'
            }
        }*/
        stage('Deploy') { 
            steps {
                sh 'echo deploy'
            }
        }
        stage('Setup Git Config') {
            steps {
                script {
                    // Set user name and email for git config
                    sh '''
                    git config --global user.email "oehlemar@students.zhaw.ch"
                    git config --global user.name "oehlemar"
                    '''
                }
            }
        }
/*         stage('Git Operations') {
            steps {
                script {
                    // Add all changes to staging area
                    sh 'git add .'

                    // Commit changes if there are any
                    sh '''
                    if git diff --cached --quiet; then
                        echo "No changes to commit."
                    else
                        git commit -m "Automated commit by Jenkins, Commit Build"
                    fi
                    '''
                    // Push changes to the configured branch
                    sh "git push --credentials ${GIT_CREDENTIALS_ID} origin ${GIT_BRANCH}"
                }
            }
        } */
    }
}

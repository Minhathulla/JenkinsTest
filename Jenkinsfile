pipeline{
  agent any{
      stages{
        stage('one'){
            steps {
              echo "stage one running succesfully"
            }
        }
        stage('two'){
            steps {
              echo "stage two started using input"
              input ('Do you want to proceed?')
            }
        }
        stage('three'){
            steps {
              echo "stage three running ..when with not condition"
              when {
                  not {
                    branch 'master'
                  }
                  steps {
                    echo 'branch name is... ' + env.GIT_BRANCH
                  }
              }
            }
        }
       stage('four'){
           parallel {
                 stage('unit_test'){
                    steps{
                         echo "parallel runnning in stage4;unit  test stage,mvn clean install"
                         mvn clean install
                    }
               }
               stage('build_test'){
                    steps{
                       echo "parallel runnning in stage4;unit  test stage, mvn test  -Dsurefire.suiteXMLFile=testng.xml"
                         mvn test  -Dsurefire.suiteXMLFile='testng.xml'
                    }
               }
           }
       }
      }
  }
}

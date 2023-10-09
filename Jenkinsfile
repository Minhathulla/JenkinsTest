pipeline{
  agent{
    node {
      label 'slave2'
    }
  }
  tools{
     maven 'MAVEN_HOME'
  }
      stages{
        stage ('one'){
            steps {
              echo "stage one running succesfully"
            }
        }
        stage ('two'){
            steps {
              echo "stage two started using input"
              input ('Do you want to proceed?')
            }
        }
        stage ('three'){
            steps {
              echo "stage three running ..when with not condition"
              script{
              if(env.BRANCH_NAME ==~ /(dev|main)/) {
                 
                   branch "main"
                  
                  steps {
                    echo "branch name is..."+ env.GIT_BRANCH
                  }
              }
            }
        }
        }
       stage ('four'){
           parallel {
                 stage ('unit_test'){
                    steps{
                         echo "parallel runnning in stage4;unit  test stage,mvn clean install"
                         bat  "mvn clean install"
                    }
               }
               stage ('build_test'){
                    steps{
                       echo "parallel runnning in stage4;unit  test stage, mvn test  -Dsurefire.suiteXMLFile=testng.xml"
                        
                    }
               }
           }
       }
      }
  
}

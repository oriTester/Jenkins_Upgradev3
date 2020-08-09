job('First-Maven-Project-Via-DSL')
    description("First maven job generated by thr DSL on ${new Date()}, the project is a small maven project hosted on github")
    scm {
        git("git@github:oriTester/Jenkins_Upgradev3.git", master)
    }
    triggers{
        scm('* * * * *')
    }
    steps{
        maven('clear package', 'maven-samples/single-module/pom.xml')
    }
    publishers {
        //archive the .war file that generated
        archiveArtifacts '**/*.war'
    }
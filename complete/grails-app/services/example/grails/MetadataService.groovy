package example.grails

import grails.config.Config
import grails.core.GrailsApplication
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileStatic

@CompileStatic
class MetadataService implements GrailsConfigurationAware {

    GrailsApplication grailsApplication

    /**
     * The Grails environment currently being used i.e. "development", "test", or "production".
     */
    String applicationEnvironment
    /**
     * "adding-build-info". The name of this Grails application.
     */
    String applicationName
    /**
     * The version of this Grails application i.e. "6.4.5"; it is the version specified in gradle.properties .
     */
    String applicationVersion
    /**
     * The build number of the application. This is only set when the application is built by a
     * CI (continuous integration) system.
     */
    String applicationBuildNumber
    /**
     * The time when the application was built, specified as a String in the format "yyyy-MM-dd HH:mm:ss".
     * This is only set when the application is built into a runnable war or jar and then deployed.
     */
    String applicationBuildTS
    /**
     * The Git revision (a.k.a. commit hash) of the source code when the application was built.
     * This is only set when the application is built into a runnable war or jar and then deployed.
     */
    String buildGitRevision
    /**
     * The Git branch of the source code when the application was built.
     * This is only set when the application is built into a runnable war or jar and then deployed.
     */
    String buildGitBranch
    /**
     * The email address of the author of the most recent Git commit when the application was built.
     * This is only set when the application is built into a runnable war or jar and then deployed.
     */
    String buildGitCommitAuthorEmail
    /**
     * The name of the author of the most recent Git commit when the application was built.
     * This is only set when the application is built into a runnable war or jar and then deployed.
     */
    String buildGitCommitAuthorName
    /**
     * The message of the most recent Git commit when the application was built.
     * This is only set when the application is built into a runnable war or jar and then deployed.
     */
    String buildGitCommitMessage
    /**
     * The Java version used when the application was built i.e. "1.8.0_345". This is only set when
     * the application is built into a runnable war or jar and then deployed.
     */
    String buildJavaVersion
    /**
     * The Grails version used to build the application.
     */
    String grailsVersion

    /**
     * Have these properties set once when the service is created.
     * http://grailsblog.objectcomputing.com/posts/2016/08/31/retrieving-config-values.html
     */
    @Override
    void setConfiguration(Config co) {
        applicationEnvironment = System.getProperty("grails.env")
        applicationName = grailsApplication.metadata.getApplicationName()
        applicationVersion = grailsApplication.metadata.getApplicationVersion()
        applicationBuildNumber = grailsApplication.metadata.getOrDefault("build.number", null)
        applicationBuildTS = grailsApplication.metadata.getOrDefault("build.time", null)
        buildGitRevision = grailsApplication.metadata.getOrDefault("build.git.revision", null)
        buildGitBranch = grailsApplication.metadata.getOrDefault("build.git.branch", null)
        buildGitCommitAuthorEmail = grailsApplication.metadata.getOrDefault("build.git.commit.user.email", null)
        buildGitCommitAuthorName = grailsApplication.metadata.getOrDefault("build.git.commit.user.name", null)
        buildGitCommitMessage = grailsApplication.metadata.getOrDefault("build.git.commit.message.full", null)
        buildJavaVersion = grailsApplication.metadata.getOrDefault("build.java.version", null)
        grailsVersion = grailsApplication.metadata.getGrailsVersion()
    }
}

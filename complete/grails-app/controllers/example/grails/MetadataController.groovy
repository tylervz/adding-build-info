package example.grails

import grails.converters.JSON
import groovy.transform.CompileStatic

@CompileStatic
class MetadataController {

    MetadataService metadataService

    def index() {
        Map info = [
            "applicationEnvironment": metadataService.applicationEnvironment,
            "applicationName": metadataService.applicationName,
            "applicationVersion": metadataService.applicationVersion,
            "applicationBuildNumber": metadataService.applicationBuildNumber,
            "applicationBuildTS": metadataService.applicationBuildTS,
            "buildGitRevision": metadataService.buildGitRevision,
            "buildGitBranch": metadataService.buildGitBranch,
            "buildGitCommitAuthorEmail": metadataService.buildGitCommitAuthorEmail,
            "buildGitCommitAuthorName": metadataService.buildGitCommitAuthorName,
            "buildGitCommitMessage": metadataService.buildGitCommitMessage,
            "buildJavaVersion": metadataService.buildJavaVersion,
            "grailsVersion": metadataService.grailsVersion,
            "currentJavaVersion": System.getProperty('java.version')
        ]
        return render(info as JSON)
    }
}

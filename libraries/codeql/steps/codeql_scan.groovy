void call() {
    def codeql_config = [
        "language": "nodejs",
        "creds": "undefined:undefined"
    ]

    if (codeql_config.containsKey("language"))codeql_config["language"] = config.language
    if (codeql_config.containsKey("creds"))codeql_config["creds"] = config.creds

    def repo_name =  "${GIT_URL}"
            .replaceAll("git@github.com:", "")
            .replaceAll(".git", "")
    echo "Running CodeQL scans"
    // sh "rm -rf codeql-db"
    // sh "curl -LO https://github.com/github/codeql-action/releases/latest/download/codeql-bundle-linux64.tar.gz"
    // sh "tar -xvzf ./codeql-bundle-linux64.tar.gz"
    // sh "codeql/codeql database create codeql-db --language=${codeql_config.language}"
    // sh "codeql/codeql database analyze codeql-db ${codeql_config.language}-security-and-quality.qls --format=sarifv2.1.0 --output=analysis-results.sarif"
    // sh "codeql/codeql github upload-results --repository=${repo_name} --ref=refs/heads/${BRANCH_NAME} --commit=${GIT_COMMIT} --sarif=analysis-results.sarif | true"
    // sh "curl --user ${codeql_config.creds} -o alerts.json https://api.github.com/repos/${repo_name}/code-scanning/alerts?ref=refs/heads/${BRANCH_NAME}&state=open&per_page=100 | true"
}
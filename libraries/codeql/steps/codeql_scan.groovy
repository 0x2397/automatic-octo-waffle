void call() {
    def codeql_defaults = [
        language: "nodejs",
        creds: "undefined:undefined"
    ]
    def codeql_config = config.withDefault(codeql_defaults.&get)
    def repo_name =  build.environment
            .get("GIT_URL")
            .replaceAll("git@github.com:", "")
            .replaceAll(".git", "")
    echo "Running CodeQL scans"
    sh "curl -LO https://github.com/github/codeql-action/releases/latest/download/codeql-bundle-linux64.tar.gz"
    sh "tar -xvzf ./codeql-bundle-linux64.tar.gz"
    sh "codeql/codeql database create codeql-db --language=${codeql_config.language}"
    sh "codeql/codeql database analyze codeql-db ${codeql_config.language}-security-and-quality.qls --format=sarifv2.1.0 --output=analysis-results.sarif"
    sh "codeql/codeql github upload-results --repository=${repo_name} --ref=refs/heads/${BRANCH_NAME} --commit=${GIT_COMMIT} --sarif=analysis-results.sarif"
    sh "curl --user ${codeql_config.creds} -o alerts.json https://api.github.com/repos/${repo_name}/code-scanning/alerts?ref=refs/heads/${BRANCH_NAME}&state=open&per_page=100"
}
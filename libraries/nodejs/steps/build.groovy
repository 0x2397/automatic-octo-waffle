void call() {
    echo "Running Node.Js build"
    sh "npm install --frozen-lockfile=false"
}
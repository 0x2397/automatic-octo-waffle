void call() {
    echo "Running Node.Js audit"
    sh "npm audit --prod --audit-level moderate"
}
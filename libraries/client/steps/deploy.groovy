void call() {
    echo "Running Client Deploy"
    echo "aws s3 sync build-dir s3://client-example-bucket"
}
**Jenkins Templating Engine Libraries**

This project includes sample Jenkins Templating Engine Libraries. These libraries are for commonly used libraries and CI Pipeline workflows, including:

-   Build
-   Deploy
-   Application Auditing
-   Pipeline Notifications
-   Testing and Static Analysis

These are all adapted as **_steps_**  implemented for each language or runtime. These steps are allowed to consume resources [yaml configuration files] necessary for the usage of the implementation.

Libary steps are also permitted to use parameters from Pipeline Configurations, entirely decoupled from Pipeline Libraries.

  

**Important Primitives**

-   Step
-   Application Environments

  

**Step**

A **step** is a logical construct that exposes APIs in JTE Libraries with implementations based on the supported runtimes or workflows in a setup.

For example:

A Jenkins workflow has a **build** step across services within the organization. The **build** concept  is standard for every CI workflow and can be templated for all workflows with runtime specific implementations.

Here,

step = build

implementations { npm build, yarn build, docker build }
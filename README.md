**Jenkins Templating Engine Libraries**

**This proje**ct includes sample Jenkins Templating Engine Libraries. These libraries are for commonly used libraries and CI Pipeline workflows, including:

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
-   Template Methods
-   Event Lifecycles

  

**Step**

A **step** is a logical construct that exposes APIs in JTE Libraries with implementations based on the supported runtimes or workflows in a setup.

For example:

A Jenkins workflow has a **build** step across services within the organization. During templating;

Here,

step = build

implementations { npm build, yarn build, docker build }

  

  

**Template Methods**

Template methods allow the definition of required steps in a particular Jenkins run with the templating engine. Steps not implemented are replaced with a no-op step logging _"step x is not implemented"._

  

**Event Lifecycles, Hooks and Context**

JTE hooks set up methods that allow a library to hook into the event lifecycle of a Jenkins Job using the engine.

These include hooks like:

-   @BeforeStep
-   @AfterStep
-   @Init
-   @Cleanup
-   @Notify

![Jenkins Templating Engine Event Lifecycle Hooks](https://boozallen.github.io/sdp-docs/jte/2.2.2/library-development/_images/lifecycle_hook.png)

**@BeforeStep**

This Groovy annotation sets up a groovy method as a hook to run before every step in a Jenkins Pipeline.

  

**@AfterStep**

This Groovy annotation sets up a groovy method as a hook to run after every step in a Jenkins Pipeline.

  

**@Init**

This Groovy annotation sets up a groovy method as a hook at the beginning of the Jenkins Pipeline.

  

**@Notify**

This Groovy annotation sets up a groovy method as a hook on every step after the **@AfterStep** in the Jenkins Pipeline.

  

**@Cleanup**

This Groovy annotation sets up a groovy method as a hook run after the end of a pipeline.
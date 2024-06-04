# webprotege-backend-api
The API for the backend monolith.  This will gradually shrink and will eventually go away once we have microservices at the correct level of granularity.

## Adding new functionality
In general, new Java interfaces, records and classes should not be added to this library.  New API interfaces should directly reside in the appropriate calling and handling microservices.

## Fixing bugs
We use [GitHub flow](https://docs.github.com/en/get-started/using-github/github-flow) for making changes to this library.  This means that to fix bugs in this library, you should create a branch of `main`, make changes in this branch and then create a pull request for the changes to be merged into `main`.  Changes will be reviewed and merged into `main` by one of the maintainers.

## Auto-versioning and auto-release

We use a GitHub workflow to manage versioning and making releases.  Developers should not set version numbers manually. 

When pull requests are merged into the `main` branch the version will be automatically be bumped.  If the pull requests contains the work "breaking" the version will be bumped by a major number e.g. 1.2.3 to 2.0.0.  If a pull requests contains the word "Feat" or "Feature" then the version will be bumped by a minor number increase e.g. 1.2.3 to 1.3.0.  For all other pull requests the version will be bumped by a patch number increase e.g. 1.2.3 to 1.2.4.

Once the version has been bumped, the library will be built, automatically deployed to Maven Central and a GitHub release will automatically be created.
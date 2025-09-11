# webprotege-backend-api

The API for the backend monolith. This will gradually shrink and eventually be phased out as we transition to microservices at the appropriate level of granularity.

## Adding New Functionality

In general, new Java interfaces, records, and classes should not be added to this library. New API interfaces should reside directly in the appropriate calling and handling microservices.

## Fixing Bugs

We use [GitHub flow](https://docs.github.com/en/get-started/using-github/github-flow) for making changes to this library. To fix bugs in this library, follow these steps:
1. Create a branch off `main`.
2. Make changes in this branch.
3. Create a pull request to merge the changes into `main`.

Changes will be reviewed and merged by one of the maintainers.


## Auto-Versioning and Auto-Release

We use a GitHub workflow to manage versioning and releases. Developers should not set version numbers manually.

When pull requests are merged into the `main` branch, the version will be automatically bumped based on the content of the pull request:
- If the pull request contains the word "breaking," the version will be bumped by a major number (e.g., 1.2.3 to 2.0.0).
- If the pull request contains the word "Feat" or "Feature," the version will be bumped by a minor number (e.g., 1.2.3 to 1.3.0).
- For all other pull requests, the version will be bumped by a patch number (e.g., 1.2.3 to 1.2.4).

After the version has been bumped, the library will be built, automatically deployed to Maven Central, and a GitHub release will be created.


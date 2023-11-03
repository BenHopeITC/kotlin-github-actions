# Gradle Git Commit Hooks
https://dev.to/akdevcraft/git-pre-hook-pre-commit-with-gradle-task-134m

1. See example scripts in .git folder
2. Create script in scripts folder
3. Update build.gradle, add task to install pre-commit hook
4. Run build command to install hook in .git, ./gradlew build
5. Verify installed successfully, cat .git/hooks/pre-commit
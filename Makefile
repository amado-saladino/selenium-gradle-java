test:
	gradle test

custom-test:
	gradlew test -P$(flavor)

# gradlew test -Psomke
# gradlew test -Pregression
# gradlew test -Pparallel

# How to run
# make custom-test flavor=[smoke, regression, parallel]
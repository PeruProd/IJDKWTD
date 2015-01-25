all:
	./gradlew desktop:dist
	cp desktop/build/libs/desktop-1.0.jar ./

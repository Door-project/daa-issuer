FROM gradle:jdk11-focal

RUN git clone -b xword-deployment https://github.com/Door-project/daa-issuer.git
WORKDIR /home/gradle/daa-issuer
RUN chmod +x gradlew

CMD ./gradlew BootRun


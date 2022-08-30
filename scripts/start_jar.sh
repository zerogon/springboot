#!/bin/bash
# Start Server Script
BUILD_HOME='/build/libs'
CONTEXT_PATH='papercpnPro-0.0.1-SNAPSHOT'
JAR_STAGED_LOCATION="$BUILD_HOME/papercpnPro-0.0.1-SNAPSHOT.jar"
# Remove unpacked application artifacts

if [[ -f $BUILD_HOME/$CONTEXT_PATH.jar ]]; then
    rm $BUILD_HOME/$CONTEXT_PATH.jar
fi

if [[ -d $BUILD_HOME/$CONTEXT_PATH ]]; then
    rm -rfv $BUILD_HOME/$CONTEXT_PATH
fi

mv $JAR_STAGED_LOCATION $BUILD_HOME/$CONTEXT_PATH.jar

nohup java -jar $BUILD_HOME/$CONTEXT_PATH.jar &



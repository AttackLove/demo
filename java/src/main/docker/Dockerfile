# Sample Dockerfile for use with the Docker file mode
FROM ${docker.base.image}

# In maven/ the files as specified in the <assembly> section is stored
# and need to be added manually
COPY maven/ /maven
CMD ["sh","-c","java ${JAVA_OPTS} -jar /maven/${project.artifactId}-${project.version}.jar"]
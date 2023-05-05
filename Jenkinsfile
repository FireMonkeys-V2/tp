pipeline {
 agent any
 tools {
 maven 'MAVEN_4_0_0'
 }
 stages {
 stage ('Compile Stage') {
 steps {
 withMaven(maven : 'MAVEN_4_0_0') {
 bat 'mvn clean compile'
 }
 }
 }
 stage ('Testing Stage') {
 steps {
 withMaven(maven : 'MAVEN_4_0_0') {
 bat 'mvn test'
 }
 }
 }
 stage ('package Stage') {
 steps {
 withMaven(maven : 'MAVEN_4_0_0') {
 bat 'mvn package'
 }
 }
 }
 }
}
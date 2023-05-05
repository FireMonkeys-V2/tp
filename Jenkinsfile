pipeline {
 agent any
 tools {
 maven 'Maven 3.9.1'
 }
 stages {
 stage ('Compile Stage') {
 steps {
 withMaven(maven : 'Maven 3.9.1') {
 bat 'mvn clean compile'
 }
 }
 }
 stage ('Testing Stage') {
 steps {
 withMaven(maven : 'Maven 3.9.1') {
 bat 'mvn test'
 }
 }
 }
 stage ('package Stage') {
 steps {
 withMaven(maven : 'Maven 3.9.1') {
 bat 'mvn package'
 }
 }
 }
 }
}
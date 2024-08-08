# qa-test-greeting
Environment: Windows.

Pre-requisite: 
	Docker:
		- Download and install docker desktop for windows.
		- Once installed check if the docker is installed from command prompt. (docker --version)
	Minikube:	
		- Download and install the Minikube. 
		- Once installed check if the Minikube is installed from command prompt. (minikube version)
	Kubernetes:
		- Download and install Kubernetes. 
		- Once installed check if the Kubernetes is installed from command prompt. (kubectl version --client)
	Maven:
		- Download and install maven if not installed.
		- Once installed check if the maven is installed from command prompt. (mvn -version)
	Java:
		- Download and install java. Make sure your java version is > 17. (java -verion).
		
	Selenium:
		- Make sure you have all selenium-java jar files in the build path of the IDE and also chrome driver. In my case i use eclipse IDE to test the automation script.
		
Procedure:
	- Start Minikube
	- clone the github project to your local directory (https://github.com/Vengatesh-m/qa-test.git)
	- Create docker images for both the frontend and backend.
		- Navigate to the frontend directory which has the frontend docker file. (Ex:D:\Equitek\qatest\qa-test\frontend)
		- docker build -t vengatesh27/frontend:v1 (This will build the image and tag it as vengatesh27/frontend:v1)
		- Navigate to the backent directory which has the backend docker file. (Ex:D:\Equitek\qatest\qa-test\backend)
		- docker build -t vengatesh27/backend:v1 (This will build the image and tag it as vengatesh27/backend:v1)
	- Load the both images in the Minikube
		- minikube image load vengatesh27/frontend:v1
		- minikube image load vengatesh27/backend:v1
	- Deploy to Kubernetes
		- kubectl apply -f backend-deployment.yaml
		- kubectl apply -f frontend-deployment.yaml
	- Check if the service is up and running
		- minikube service frontend-service (Should invoke the browser and show the frontend page)
	- Script 
		- Create a maven project 
		- create a java class FindGreetingText.java
		- run the test using command (mvn test)
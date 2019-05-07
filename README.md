# springboot-dubbo-example
springboot-dubbo-example  with provider and  consumer 

First start DubboServerApplication as a service application.

Then start DubboConsumerApplication as a consumer application.

Make sure you have your zookeeper started.

Then go to visit http://localhost:8081/save_user
you will get a result like this:
{"id":0,"password":"eb0c3966-a749-4995-9418-c48ba0f3cd10","userName":"bbbbb"}

Now you have successfully experienced spring boot integrate with dubbo.

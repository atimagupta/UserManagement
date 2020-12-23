To Run the project
___________________
1) Download from given git repository 
2) Build the project using pom.xml
3) build docker image
4) run above docker image within docker container


End-Points
______________
**1) Create the user**
   http://localhost:8081/user/create
   
   payload - {
   "email": "abcdsdasd@accenture.com",
   "name": "11abc",
   "password": "abc@1234",
   "role": {
   "permissionList": [
   {
   "permission": "ALL"
   }
   ],
   "role": "ADMIN"
   },
   "userName": "abc@1234"
   }
   
   Response-{
   "_id": "5fe2a80b1a5a263e053d6632",
   "name": "11abc",
   "userName": "abc@1234",
   "email": "abcdsdasd@accenture.com",
   "password": "$2a$10$hQPsx85Rg0ncVoi6XMG2Iek9Gq8.JUZ7Fkrt4gJm7juh6a7UN.qEm",
   "role": {
   "role": "ADMIN",
   "permissionList": [
   {
   "permission": "ALL"
   }
   ]
   }
   }

**2) Fetch user details**
   http://localhost:8081/user/read/abc@1234
   
   Rsp:- {
   "_id": "5fe2a80b1a5a263e053d6632",
   "name": "11abc",
   "userName": "abc@1234",
   "email": "abcdsdasd@accenture.com",
   "password": "$2a$10$hQPsx85Rg0ncVoi6XMG2Iek9Gq8.JUZ7Fkrt4gJm7juh6a7UN.qEm",
   "role": {
   "role": "ADMIN",
   "permissionList": [
   {
   "permission": "ALL"
   }
   ]
   }
   }
   
**3) delete the user**
   http://localhost:8081/user/delete
   {
   "email": "abcdsdasd@accenture.com",
   "name": "11abc",
   "password": "abc@1234",
   "role": {
   "permissionList": [
   {
   "permission": "ALL"
   }
   ],
   "role": "ADMIN"
   },
   "_id": "5fe2a9641a5a263e053d6633",
   "userName": "abc@1234"
   }

**4) change password**
   http://localhost:8081/user/updatePassword/abc@1234
   {
   "password": "dedfedf"
   }

**5) Login**
   http://localhost:8081/user/login/abc@1234
   {
   "password": "dedfedf"
   }
   
**6) Update user details**
   http://localhost:8081/user/update

   payload - {
   "email": "abcdsdasd@accenture.com",
   "name": "22abc",
   "password": "abc@1234",
   "role": {
   "permissionList": [
   {
   "permission": "ALL"
   }
   ],
   "role": "ADMIN"
   },
   "_id": "5fe2a80b1a5a263e053d6632",
   "userName": "abc@1234"
   }

   Response-{
   "_id": "5fe2a80b1a5a263e053d6632",
   "name": "22abc",
   "userName": "abc@1234",
   "email": "abcdsdasd@accenture.com",
   "password": "$2a$10$hQPsx85Rg0ncVoi6XMG2Iek9Gq8.JUZ7Fkrt4gJm7juh6a7UN.qEm",
   "role": {
   "role": "ADMIN",
   "permissionList": [
   {
   "permission": "ALL"
   }
   ]
   }
   }
   
**7) Add permissions to the user**
   http://localhost:8081/user/addPermission/abc@1234
   { "role": "NORMAL", "permissionList": [ { "permission": "ALL" } ]
   }
   
Time Taken
_______________
7 hrs

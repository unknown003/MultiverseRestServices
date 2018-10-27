# MultiverseRestServices
Developed Rest Services using java, spring framework, jdbc ,mysql

** Steps to run: **     
-------------------------------------------------------------------
  
1.Import mysql tables in to database.  
2.Import this project as maven project in eclipse.  
3.Build war file.  
4.Run on local server.  

** Provided Rest Services are: **
-------------------------------------------------------------------

url for creating a person   
method:  POST  
-------------------------------------------------------------------
......./person   
-------------------------------------------------------------------
Example:
http://localhost:8080/multiverse/person  
Request:  
{  
	"name":"lavannnmmm",  
	"familyId":5,   
	"universeId":1,  
	"power":5   
}    
Response:  
{   
    "responseCode": 200,  
    "developerMessages": null,  
    "creationStatus": true  
} 


url for getting all persons  
Method: GET
-------------------------------------------------------------------
.../persons
-------------------------------------------------------------------
Example:
http://localhost:8080/multiverse/persons/ 
Response

{  
    "responseCode": 200,  
    "developerMessages": null,  
    "count": 5,  
    "persons": [  
        {  
            "name": "person3",  
            "familyId": 1,  
            "universeId": 1,  
            "power": 28  
        },  
        {  
            "name": "person4",  
            "familyId": 1,  
            "universeId": 2,  
            "power": 13  
        },  
        {  
            "name": "lavannnmmm",  
            "familyId": 1,  
            "universeId": 2,  
            "power": 10  
        },
        {
            "name": "lavan",  
            "familyId": 1,  
            "universeId": 3,  
            "power": 11  
        },
        {
            "name": "lavannnmmm",  
            "familyId": 1,  
            "universeId": 3,  
            "power": 10  
        }  
    ]  
}  


url for checking power of families of same id in all universes    
method :  GET   
-------------------------------------------------------------------
....../families/power/check/  
-------------------------------------------------------------------
Example
http://localhost:8080/multiverse/families/power/check/  

Response  
{  
    "responseCode": 200,  
    "developerMessages": null,  
    "families": [  
        {  
            "familyId": 1,  
            "balanced": true  
        },  
        {  
            "familyId": 2,  
            "balanced": true  
        },  
        {  
            "familyId": 4,  
            "balanced": true  
        },  
        {  
            "familyId": 5,  
            "balanced": true  
        }  
    ]  
}  


URL for balancing power  
method :  POST
-------------------------------------------------------------------
......../families/power/balance
-------------------------------------------------------------------
Example:
http://localhost:8080/multiverse/families/power/balance   

Response  
{  
    "responseCode": 200,    
    "developerMessages": null,    
    "familyDetails": [    
        {    
            "familyId": 1,    
            "universeId": 1,    
            "familypower": 21  
        },  
        {
            "familyId": 1,  
            "universeId": 2,  
            "familypower": 21  
        }  
	...  
    ],  
    "noofFamilies": 2
}

url for getting family ids in a  particular universe    
Method: GET  
-------------------------------------------------------------------
...../universe/{universe_id}/families
-------------------------------------------------------------------
  
Example:  
http://localhost:8080/multiverse/universe/1/families     

Response:  
{  
    "responseCode": 200,  
    "developerMessages": null,  
    "familyIds": [  
        1,  
        2,  
        5  
    ],  
    "count": 3   
}  
URL  for getting all families   
Method:  GET
-------------------------------------------------------------------
.../families
-------------------------------------------------------------------

Example
http://localhost:8080/multiverse/families/   

Response    

{
    "responseCode": 200,  
    "developerMessages": null,  
    "familyDetails": [  
        {  
            "familyId": 1,  
            "universeId": 1,  
            "familypower": 21  
        },  
        {  
            "familyId": 1,  
            "universeId": 2,  
            "familypower": 21  
        },  
        {  
            "familyId": 1,  
            "universeId": 3,  
            "familypower": 21  
        }  
    ],
    "noofFamilies": 3
}

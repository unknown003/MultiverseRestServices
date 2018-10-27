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

url for creating a person is  
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
created user  


url for getting all persons
Method: GET
-------------------------------------------------------------------
.../persons/all
-------------------------------------------------------------------
Example:
http://localhost:8080/multiverse/persons/all  
Response

[  
    {  
        "name": "person3",  
        "familyId": 1,  
        "universeId": 1,  
        "power": 21  
    },  
    {  
        "name": "person4",  
        "familyId": 1,  
        "universeId": 2,  
        "power": 11  
    },
    {   
        "name": "lavannnmmm",  
        "familyId": 1,  
        "universeId": 2,  
        "power": 10  
    }  
]    


url for checking power of families of same id in all universes    
method :  GET   
-------------------------------------------------------------------
....../families/power/check/  
-------------------------------------------------------------------
Example
http://localhost:8080/multiverse/families/power/check/  

Response  
[  
    {  
        "familyId": 1,    
        "balanced": false  
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


URL for balancing power
-------------------------------------------------------------------
......../families/power/balance
-------------------------------------------------------------------
Example:
http://localhost:8080/multiverse/families/power/balance   

Response  
[  
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
]    

url for getting family ids in a  particular universe is    
Method: GET  
-------------------------------------------------------------------
...../universe/{universe_id}/families
-------------------------------------------------------------------
Example:  
http://localhost:8080/multiverse/universe/1/families     
Response:  
[   
    1,  
    2,  
    5  
]

URL  for getting all families is
Method:  GET
-------------------------------------------------------------------
.../families/all
-------------------------------------------------------------------
Example
http://localhost:8080/multiverse//families/all    

Response    

[  
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
]      

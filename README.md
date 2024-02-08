# Bitespeed-Backend-Task
Identity Reconciliation 

Method: POST

Endpoint: `https://****.com/identify`

Request Body:{
"email":"george@hillvalley.edu",
"phoneNumber": "717171"
}
Response:	{
		"contact":{
			"primaryContatctId": 11,
			"emails": ["george@hillvalley.edu","biffsucks@hillvalley.edu"]
			"phoneNumbers": ["919191","717171"]
			"secondaryContactIds": [27]
		}
	}

![Screenshot (186)](https://github.com/Rohith2050/Bitespeed-Backend-Task/assets/87187293/a786b602-674f-498e-bb6f-3fb637b77a0e)

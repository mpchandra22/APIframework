Feature: Create New Change Request
  	
  Scenario: Create a new Request without Body
	Given enable logs
	When new change request is created
	Then the status code is 201
	And response includes the following
	|result.sys_created_by|admin|
	|result.sys_class_name|change_request|
	
	
	
	
	
	
	
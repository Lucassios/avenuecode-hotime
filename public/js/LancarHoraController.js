angular.module("hotime",[]).controller('LancarHoraController',ControllerSettings);

function ControllerSettings(){
	this.userId = "1234";
	this.userPosition = [
	{
		id:"1",
		description:"Tester"
	},
	{
		id:"2",
		description:"Marketing"
	},
	{
		id:"3",
		description:"Software Engineering"
	}];
	
	this.workedNormalHours = 4;
	this.workedExtraHours = 4;
	
	this.HoursData = {
			date:'10/12/1987',
			normalHours:8,
			extrasHours:10
				
	}
	
}

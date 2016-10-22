var peerApp    =   angular.module('peersApp', [])
 
peerApp.controller("BlogCtrl", function ($scope){
$scope.blogs = [
                {'name':'yappy',
                 'content':'fgthyui',
                 'reason':'dfghjuki',
                 'status':'xcdfghj',
                 'title':'azxsdfg'},
                ];
   $scope.removeRow = function(bid){
	   cosole.log("remove the blog"+ bid)
	   var index = -1
	   var blogList = eval( "$scope.blogs" );
	    for (var i = 0; i < blogList.length;i++ ) {
	    	if(BlogList[i].id === name){
	    		
	    		index=i;
	    		break;
	    	}
	    }
	    if( index == -1) {
	    	alert ("smenthing went wrong");
	    }
	    $scope.blogs.splice(index, 1);
	    
	    };
	    	
	    	
});
	   
	
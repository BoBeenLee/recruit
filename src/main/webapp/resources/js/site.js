var siteCtrl = function($scope, $http) {
	$scope.siteGroups = [];
	
	$scope.init = function() {
	}
	$scope.site = function(url, id, link) {
		$http.get(url + '?id=' + id).then(function (response) {
			var data = response.data;
			
			$scope.siteGroups.length = 0;
			for(var i=0; i<data.siteGroups.length; i++)
				$scope.siteGroups.push(data.siteGroups[i]);
			$scope.link = data.site.url;
		},
        function (data) {
        	console.log(data + " error");
        });
	}
};

var addCtrl = function($scope) {
	$scope.numbers = [];
	$scope.count = 0;

	$scope.init = function() {
	}
	$scope.add = function() {
		$scope.count += 1;
		$scope.numbers.push($scope.count);
	}
	$scope.remove = function(index) {
		$scope.numbers.splice(index, 1);
	}
};

var myAppModule = angular.module('site', [])
.controller('SiteCtrl', siteCtrl)
.controller('AddCtrl', addCtrl);
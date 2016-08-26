angular.module("app", []).controller('MainController', function($scope, $http) {

    $scope.projects = []
    var chart = venn.VennDiagram();

    $scope.getProjects = function() {
        //TODO hook up with back-end
        if(false) {
            $http.get('/projects')
                .success(function (data) {
                    $scope.projects = data;
                })
                .error(function (data) {
                    $scope.projects = []
                    console.log("Error while loading projects")
                })
        } else {
            $scope.projects = [
                {name: 'Project 1', id: 1},
                {name: 'Project 2', id: 2},
                {name: 'Project 3', id: 3}
            ]
        }
    };

    $scope.getStoryLists = function() {
        if(false) {
            //TODO hookup to back-end
            $http.get('')
        } else {
            return {
                acceptanceCriteria: ['PVP-1', 'PVP-2', 'PVP-3', 'PVP-10', 'PVP-11', 'PVP-12', 'PVP-13'],
                validStory: ['PVP-1', 'PVP-2', 'PVP-4', 'PVP-5', 'PVP-6', 'PVP-11'],
                validDesc: ['PVP-1', 'PVP-4', 'PVP-7', 'PVP-10', 'PVP-12']
            }
        }
    };

    $scope.setUpVenn = function() {
        var storyBuckets = $scope.getStoryLists();
        
        var lengthA = storyBuckets.acceptanceCriteria.length;
        var lengthB = storyBuckets.validStory.length;
        var lengthC = storyBuckets.validDesc.length;

        //TODO put these in a resource file?
        var titleA ='Acceptance Criteria \n Size='+lengthA;
        var titleB ='Valid Story \n Size='+lengthB;
        var titleC ='Valid Description \n Size='+lengthC;

        var listAB = $scope.findMatches(storyBuckets.acceptanceCriteria, storyBuckets.validStory) || ['PVP-1', 'PVP-2', 'PVP-11'];
        var listAC = $scope.findMatches(storyBuckets.acceptanceCriteria, storyBuckets.validDesc) || ['PVP-1', 'PVP-12'];
        var listBC = $scope.findMatches(storyBuckets.validStory, storyBuckets.validDesc) || ['PVP-1', 'PVP-4'];
        var listABC = $scope.findMatches(storyBuckets.acceptanceCriteria, storyBuckets.validDesc, storyBuckets.validStory) || ['PVP-1'];
        
        var sets = [
            {sets: [titleA], size: lengthA},
            {sets: [titleB], size: lengthB},
            {sets: [titleC], size: lengthC},
            {sets: [titleA, titleB], size: listAB.length},
            {sets: [titleA, titleC], size: listAC.length},
            {sets: [titleB, titleC], size: listBC.length},
            {sets: [titleA, titleB, titleC], size: listABC.length}
        ];
        return sets;
    };

    //TODO
    $scope.findMatches = function(listA, listB, listC) {
        // return a list of the matching stories
        return undefined;
    }

    var sets = $scope.setUpVenn();
    $scope.getProjects()
    d3.select("#venn").datum(sets).call(chart);
});
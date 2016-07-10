/** * Configure the Routes */
cloudStreetMarketApp.config(function ($locationProvider, $routeProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/index', {
            templateUrl: 'html/home.html',
            controller: 'homeMainController'
        })
        .when('/', {
            templateUrl: 'html/home.html',
            controller: 'homeMainController'
        })
        .when('/indices-:name', {
            templateUrl: '/html/indices-by-market.html',
            controller: 'indicesByMarketTableController'
        })
        .when('/stock-search', {
            templateUrl: '/html/stock-search.html',
            controller: 'stockSearchMainController'
        })
        .when('/stock-search-by-market', {
            templateUrl: '/html/stock-search-by-market.html',
            controller: 'stockSearchByMarketMainController'
        })
        .when('/stocks-risers-fallers', {
            templateUrl: '/html/stocks-risers-fallers.html',
            controller: 'stocksRisersFallersMainController'
        })
        .otherwise({redirectTo: '/'});
});

cloudStreetMarketApp.controller("homeMainController", function ($scope) {
});
cloudStreetMarketApp.controller("indicesByMarketsMainController", function ($scope) {
})
cloudStreetMarketApp.controller("stockSearchMainController", function ($scope) {
})
cloudStreetMarketApp.controller("stockSearchByMarketMainController", function ($scope) {
})
cloudStreetMarketApp.controller("stocksRisersFallersMainController", function ($scope) {
})


# FlightSearchApi-for-Amadeus-with-Spring-Boot
 Flight Searcher RestApi

While doing the project, spring initializr has used.
I used spring boot web , spring authentication , mysql for database , spring devtool.
Project has Entity package which has 2 classes (City, Flight), 
Repository package which has 2 Interfaces (ICityDal, IFlightDal),
Service package which has 2 classes (CityService, FlightService),
Controller packace which has 3 classes (CityController, FlightController, SearchController).
Project has an endpoint which is ServiceController.
Project has scheduled background job and it collects flight datas every day of 12.00 PM.
Project is a RestFulAPi
Jparepository extended by Repository package interfaces.

 

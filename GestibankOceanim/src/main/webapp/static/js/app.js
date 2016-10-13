'use strict';
// declaration de module
var App = angular.module('myApp',['ngRoute','ngAnimate', 'ngSanitize','ui.bootstrap','ui.router']);
var dem={date:'12-09-2016',nClient:'01294', nom:'Zozor', lab:'Demande de chéquier'}
var dem2={date:'12-09-2016',nClient:'01294', nom:'Zozor1', lab:'Demande de chéquier1'}
var listDemandes =[dem, dem, dem,dem,dem2,dem2,dem2,dem2]


var demIns={date:'12-09-2016', nom:'Zozor', etat:"En attente"}
var listdemIns=[demIns,demIns,demIns,demIns,demIns,demIns]


var comopte={nClient:'12345', nom:'Zozor', solde:"12398"}
var listComptes=[comopte,comopte,comopte,comopte,comopte,comopte]

var routerApp = angular.module('routerApp', ['ui.bootstrap','ui.router']);

	
	
	
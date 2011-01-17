package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.RouteItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedRouteEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.RouteDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	
	public class RouteItemRendererController
	{
		public function RouteItemRendererController()
		{
		}
		public var view:RouteItemRendererView;
		
		public function popUp():void
		{
			var routeDetails:RouteDetails = new RouteDetails();
			routeDetails.addEventListener(SelectedRouteEvent.SELECTED_ROUTE_EVENT,selectedRouteEventHandler);
			MyPopUpManager.addPopUp(routeDetails,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(routeDetails);
		}
		private function selectedRouteEventHandler(event:SelectedRouteEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}
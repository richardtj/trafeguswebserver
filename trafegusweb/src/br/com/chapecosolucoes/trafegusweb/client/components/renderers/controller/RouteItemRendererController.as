package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.RouteItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.RouteDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	
	public class RouteItemRendererController
	{
		public function RouteItemRendererController()
		{
		}
		public var view:RouteItemRendererView;
		
		public function popUp():void
		{
			var routeDetails:RouteDetails = new RouteDetails();
			PopUpManager.addPopUp(routeDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(routeDetails);
		}
	}
}
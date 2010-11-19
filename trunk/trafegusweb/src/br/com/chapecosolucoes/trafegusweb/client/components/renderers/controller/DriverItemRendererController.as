package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.DriverItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.DriverDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.Application;
	import mx.core.FlexGlobals;
	import mx.core.IFlexDisplayObject;
	import mx.managers.PopUpManager;

	public class DriverItemRendererController
	{
		public function DriverItemRendererController()
		{
		}
		public var view:DriverItemRendererView;
		public function popUp(param:String):void
		{
			var driverDetails:DriverDetails = new DriverDetails();
			driverDetails.cpfMotoristaPrincipal = param;
			PopUpManager.addPopUp(driverDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(driverDetails);
		}
	}
}
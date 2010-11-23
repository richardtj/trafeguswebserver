package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.VehicleItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehicleDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

	public class VehicleItemRendererController
	{
		public function VehicleItemRendererController()
		{
		}
		public var view:VehicleItemRendererView;
		public function popUp(placa:String):void
		{
			var vehicleDetails:VehicleDetails = new VehicleDetails();
			vehicleDetails.placa = placa;
			PopUpManager.addPopUp(vehicleDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(vehicleDetails);
		}
	}
}
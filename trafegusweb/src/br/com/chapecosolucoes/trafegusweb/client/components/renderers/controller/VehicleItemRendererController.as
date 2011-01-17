package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.VehicleItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehicleDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

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
			vehicleDetails.addEventListener(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,selectedVehicleEventHandler);
			MyPopUpManager.addPopUp(vehicleDetails,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(vehicleDetails);
		}
		private function selectedVehicleEventHandler(event:SelectedVehicleEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}
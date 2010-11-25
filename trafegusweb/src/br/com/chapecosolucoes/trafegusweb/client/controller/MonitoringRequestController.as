package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddCarretasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddParadasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

	public class MonitoringRequestController
	{
		public function MonitoringRequestController()
		{
		}
		public var view:MonitoringRequestWiew;
		public function veiculoZoomDispatcher():void
		{
			var veiculoZoom:VeiculoZoom = new VeiculoZoom();
			veiculoZoom.addEventListener(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,selectedVehicleEventHandler);
			PopUpManager.addPopUp(veiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(veiculoZoom);
		}
		public function selectedVehicleEventHandler(event:SelectedVehicleEvent):void
		{
			this.view.veiculoZoom.cod.text = event.veiculo.cod;
			this.view.veiculoZoom.detail.text = event.veiculo.vehiclePlate;
		}
		public function addCarretas():void
		{
			var addCarretasView:AddCarretasView = new AddCarretasView();
			PopUpManager.addPopUp(addCarretasView,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(addCarretasView);
		}
		public function addParadas():void
		{
			var addParadasView:AddParadasView = new AddParadasView();
			PopUpManager.addPopUp(addParadasView,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(addParadasView);
		}
	}
}
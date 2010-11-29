package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.EmbarcadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.MotoristaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.RotaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedDriverEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedRouteEvent;
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
		public function motoristaZoomDispatcher():void
		{
			var motoristaZoom:MotoristaZoom = new MotoristaZoom();
			motoristaZoom.addEventListener(SelectedDriverEvent.SELECTED_DRIVER_EVENT,selectedDriverEventHandler);
			PopUpManager.addPopUp(motoristaZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(motoristaZoom);
		}
		private function selectedDriverEventHandler(event:SelectedDriverEvent):void
		{
			this.view.motoristaZoom.cod.text = event.motorista.codigo;
			this.view.motoristaZoom.detail.text = event.motorista.motoristaPrincipal;
		}
		public function rotaZoomDispatcher():void
		{
			var rotaZoom:RotaZoom = new RotaZoom();
			rotaZoom.addEventListener(SelectedRouteEvent.SELECTED_ROUTE_EVENT,selectedRouteEventHandler);
			PopUpManager.addPopUp(rotaZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(rotaZoom);
		}
		private function selectedRouteEventHandler(event:SelectedRouteEvent):void
		{
			this.view.rotaZoom.cod.text = event.route.codigo;
			this.view.rotaZoom.detail.text = event.route.descricao;
		}
		public function embarcadoresZoomDispatcher():void
		{
			var embarcadoresZoom:EmbarcadoresZoom = new EmbarcadoresZoom();
			embarcadoresZoom.addEventListener(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,embarcadorSelecionadoEventHandler);
			PopUpManager.addPopUp(embarcadoresZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(embarcadoresZoom);
		}
		private function embarcadorSelecionadoEventHandler(event:EmbarcadorSelecionadoEvent):void
		{
			this.view.embarcadorZoom.cod.text = event.embarcador.codigo;
			this.view.embarcadorZoom.detail.text = event.embarcador.nome;
		}
		public function locaisZoomDispatcher(enum:LocaisEnum):void
		{
			
		}
	}
}
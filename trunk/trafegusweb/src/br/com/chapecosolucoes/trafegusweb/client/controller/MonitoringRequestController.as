package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.EmbarcadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.LocaisZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.MotoristaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PGRZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.RotaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TipoTransporteZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TransportadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.AddParadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedDriverEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedRouteEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoTransporteSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TransportadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
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
			this.view.veiculoZoom.cod = event.veiculo.cod;
			this.view.veiculoZoom.detail = event.veiculo.vehiclePlate;
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
			this.view.motoristaZoom.cod = event.motorista.codigo;
			this.view.motoristaZoom.detail = event.motorista.motoristaPrincipal;
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
			this.view.rotaZoom.cod = event.route.codigo;
			this.view.rotaZoom.detail = event.route.descricao;
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
			this.view.embarcadorZoom.cod = event.embarcador.codigo;
			this.view.embarcadorZoom.detail = event.embarcador.nome;
		}
		public function locaisZoomDispatcher(enum:LocaisEnum):void
		{
			var locaisZoom:LocaisZoom = new LocaisZoom();
			if(enum == LocaisEnum.ORIGEM)
			{
				locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,origemSelecionadaEventHandler);
			}
			else if(enum == LocaisEnum.DESTINO)
			{
				locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,destinoSelecionadoEventHandler);
			}
			PopUpManager.addPopUp(locaisZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(locaisZoom);
		}
		private function origemSelecionadaEventHandler(event:SelectedLocalEvent):void
		{
			this.view.origemZoom.cod = event.local.codigo;
			this.view.origemZoom.detail = event.local.descricao;
		}
		private function destinoSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			this.view.destinoZoom.cod = event.local.codigo;
			this.view.destinoZoom.detail = event.local.descricao;
		}
		public function transportadorZoomDispatcher():void
		{
			var transportadoresZoom:TransportadoresZoom = new TransportadoresZoom();
			transportadoresZoom.addEventListener(TransportadorSelecionadoEvent.TRANSPORTADOR_SELECIONADO_EVENT,transportadorSelecionadoEventHandler);
			PopUpManager.addPopUp(transportadoresZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(transportadoresZoom);
		}
		private function transportadorSelecionadoEventHandler(event:TransportadorSelecionadoEvent):void
		{
			this.view.transportadorZoom.cod = event.transportador.codigo;
			this.view.transportadorZoom.detail = event.transportador.nome;
		}
		public function tipoTransporteZoomDispatcher():void
		{
			var tipoTransporteZoom:TipoTransporteZoom = new TipoTransporteZoom();
			tipoTransporteZoom.addEventListener(TipoTransporteSelecionadoEvent.TIPO_TRANSPORTE_SELECIONADO_EVENT,tipoTransporteSelecionadoEventHandler);
			PopUpManager.addPopUp(tipoTransporteZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(tipoTransporteZoom);
		}
		private function tipoTransporteSelecionadoEventHandler(event:TipoTransporteSelecionadoEvent):void
		{
			this.view.tipoViagemZoom.cod = event.tipoTransporte.codigo;
			this.view.tipoViagemZoom.detail = event.tipoTransporte.descricao;
		}
		public function paradaSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			MainModel.getInstance().paradasArray.addItem(event.local);
		}
		public function removeParada():void
		{
			if(this.view.grid.selectedIndex != -1)
			{
				MainModel.getInstance().paradasArray.removeItemAt(MainModel.getInstance().paradasArray.getItemIndex(this.view.grid.selectedItem));
			}
			else
			{
				Alert.show("Nenhum item selecionado.");
			}				
		}
		public function addParadaZoomDispatcher():void
		{
			var addParada:AddParadasView = new AddParadasView();
			addParada.addEventListener(AddParadaEvent.PARADA_ADICIONADA_EVENT,paradaAdicionadaEventHandler);
			PopUpManager.addPopUp(addParada,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(addParada);
		}
		private function paradaAdicionadaEventHandler(event:AddParadaEvent):void
		{
			MainModel.getInstance().paradasArray.addItem(event.parada);
		}
		public function planoGRZoomDispatcher():void
		{
			var pgrZoom:PGRZoom = new PGRZoom();
			pgrZoom.addEventListener(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,pgrSelecionadoEventHandler);
			PopUpManager.addPopUp(pgrZoom,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(pgrZoom);
		}
		private function pgrSelecionadoEventHandler(event:PGRSelecionadoEvent):void
		{
			this.view.pgrZoom.cod = event.pgr.codigo;
			this.view.pgrZoom.detail = event.pgr.descricao;
		}
	}
}
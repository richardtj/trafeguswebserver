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
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ViagemPaiZoom;
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
	import br.com.chapecosolucoes.trafegusweb.client.events.ViagemPaiSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ZoomCodDetailEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddCarretasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddParadasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.rpc.events.ResultEvent;
	
	import org.flexunit.runner.Result;

	public class MonitoringRequestController
	{
		public function MonitoringRequestController()
		{
		}
		public var view:MonitoringRequestWiew;
		public function veiculoZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var veiculoZoom:VeiculoZoom = new VeiculoZoom();
				veiculoZoom.addEventListener(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,selectedVehicleEventHandler);
				PopUpManager.addPopUp(veiculoZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(veiculoZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoVeiculo(solicitaDescricaoVeiculoResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.veiculoZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.veiculoZoom.detail = obj.veic_placa.toString();
			}
		}
		public function selectedVehicleEventHandler(event:SelectedVehicleEvent):void
		{
			this.view.veiculoZoom.cod = event.veiculo.cod;
			this.view.veiculoZoom.detail = event.veiculo.vehiclePlate;
			MainModel.getInstance().solicitacaoMonitoramentoVO.placaTruc = event.veiculo.vehiclePlate;
			this.view.dadosAdicionaisView.atualizaTerminais();
		}
		public function addCarretas():void
		{
			var addCarretasView:AddCarretasView = new AddCarretasView();
			PopUpManager.addPopUp(addCarretasView,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(addCarretasView);
		}
		public function addParadas():void
		{
			var addParadasView:AddParadasView = new AddParadasView();
			PopUpManager.addPopUp(addParadasView,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(addParadasView);
		}
		public function motoristaZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var motoristaZoom:MotoristaZoom = new MotoristaZoom();
				motoristaZoom.addEventListener(SelectedDriverEvent.SELECTED_DRIVER_EVENT,selectedDriverEventHandler);
				PopUpManager.addPopUp(motoristaZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(motoristaZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoMotorista(solicitaDescricaoMotoristaResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoMotoristaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.motoristaZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.motoristaZoom.detail = obj.pess_nome.toString();
			}
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
			PopUpManager.addPopUp(rotaZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(rotaZoom);
		}
		private function selectedRouteEventHandler(event:SelectedRouteEvent):void
		{
			this.view.rotaZoom.cod = event.route.codigo;
			this.view.rotaZoom.detail = event.route.descricao;
		}
		public function embarcadoresZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var embarcadoresZoom:EmbarcadoresZoom = new EmbarcadoresZoom();
				embarcadoresZoom.addEventListener(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,embarcadorSelecionadoEventHandler);
				PopUpManager.addPopUp(embarcadoresZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(embarcadoresZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoEmbarcador(solicitaDescricaoEmbarcadorResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoEmbarcadorResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.embarcadorZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.embarcadorZoom.detail = obj.pess_nome.toString();
			}
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
			PopUpManager.addPopUp(locaisZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
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
		public function transportadorZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var transportadoresZoom:TransportadoresZoom = new TransportadoresZoom();
				transportadoresZoom.addEventListener(TransportadorSelecionadoEvent.TRANSPORTADOR_SELECIONADO_EVENT,transportadorSelecionadoEventHandler);
				PopUpManager.addPopUp(transportadoresZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(transportadoresZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoTransportador(solicitaDescricaoTransportadorResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoTransportadorResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.transportadorZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.transportadorZoom.detail = obj.pess_nome.toString();
			}
		}
		private function transportadorSelecionadoEventHandler(event:TransportadorSelecionadoEvent):void
		{
			this.view.transportadorZoom.cod = event.transportador.codigo;
			this.view.transportadorZoom.detail = event.transportador.nome;
		}
		public function tipoTransporteZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var tipoTransporteZoom:TipoTransporteZoom = new TipoTransporteZoom();
				tipoTransporteZoom.addEventListener(TipoTransporteSelecionadoEvent.TIPO_TRANSPORTE_SELECIONADO_EVENT,tipoTransporteSelecionadoEventHandler);
				PopUpManager.addPopUp(tipoTransporteZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(tipoTransporteZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoTipoTransporte(solicitaDescricaoTipoTransporteEventHandler,event.cod);
			}
		}
		private function solicitaDescricaoTipoTransporteEventHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.tipoViagemZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.tipoViagemZoom.detail = obj.ttra_descricao.toString();
			}
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
		/*public function removeParada():void
		{
			if(this.view.grid.selectedIndex != -1)
			{
				MainModel.getInstance().paradasArray.removeItemAt(MainModel.getInstance().paradasArray.getItemIndex(this.view.grid.selectedItem));
			}
			else
			{
				Alert.show("Nenhum item selecionado.");
			}				
		}*/
		public function addParadaZoomDispatcher():void
		{
			var addParada:AddParadasView = new AddParadasView();
			addParada.addEventListener(AddParadaEvent.PARADA_ADICIONADA_EVENT,paradaAdicionadaEventHandler);
			PopUpManager.addPopUp(addParada,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(addParada);
		}
		private function paradaAdicionadaEventHandler(event:AddParadaEvent):void
		{
			MainModel.getInstance().paradasArray.addItem(event.parada);
		}
		public function planoGRZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var pgrZoom:PGRZoom = new PGRZoom();
				pgrZoom.addEventListener(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,pgrSelecionadoEventHandler);
				PopUpManager.addPopUp(pgrZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(pgrZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoPGR(solicitaDescricaoPGRResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoPGRResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.pgrZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.pgrZoom.detail = obj.pgpg_descricao.toString();
			}
		}
		private function pgrSelecionadoEventHandler(event:PGRSelecionadoEvent):void
		{
			this.view.pgrZoom.cod = event.pgr.codigo;
			this.view.pgrZoom.detail = event.pgr.descricao;
		}
		public function viagemPaiZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var viagemPaiZoom:ViagemPaiZoom = new ViagemPaiZoom();
				viagemPaiZoom.addEventListener(ViagemPaiSelecionadaEvent.VIAGEM_PAI_SELECIONADA_EVENT,viagemPaiSelecionadaResultHandler);
				PopUpManager.addPopUp(viagemPaiZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
				PopUpManager.centerPopUp(viagemPaiZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoViagemPai(solicitaDescricaoViagemPaiResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoViagemPaiResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.view.viagemPaiZoom.detail = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.view.viagemPaiZoom.detail = obj.viag_previsao_inicio.toString() + " / " + obj.viag_previsao_fim.toString();
			}
		}
		private function viagemPaiSelecionadaResultHandler(event:ViagemPaiSelecionadaEvent):void
		{
			this.view.viagemPaiZoom.cod = event.viagemPai.codigo;
			this.view.viagemPaiZoom.detail = event.viagemPai.previsaoInicio + " / " + event.viagemPai.previsaoFim;
		}
	}
}